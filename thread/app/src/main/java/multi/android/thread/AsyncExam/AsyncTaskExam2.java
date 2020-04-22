package multi.android.thread.AsyncExam;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.thread.R;

public class AsyncTaskExam2 extends AppCompatActivity {
    TextView view1;
    ImageView examimg;

    ProgressBar progressBar;
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task_exam2);
        view1 = findViewById(R.id.examtxt);
        examimg =findViewById(R.id.examimg);
        progressBar =findViewById(R.id.exampb);
        btn1 = findViewById(R.id.exambtn1);
        btn2 = findViewById(R.id.exambtn2);
        final AsyncTaskExam asyncTaskExam = new AsyncTaskExam();
        //매개변수를 정의하면 매개변수가 doInBackground로 호출될때 전달

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTaskExam.execute();
                btn1.setEnabled(false);
                btn2.setEnabled(true);

            }
        });
    }


    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    //Void
    class AsyncTaskExam extends AsyncTask<Void,Integer,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... integers) {
            int a=0;
            for (int i =1 ; i <=50 ; i++){
                a = a+i;
                SystemClock.sleep(200);
                if (i%2==0){
                    publishProgress(R.drawable.d1,i);
                }else{
                    publishProgress(R.drawable.d2,i);
                }

            }
            return String.valueOf(a);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //doInBackground에서 발생하는 값을 이용해서 화면을 변경하고 싶은 경우

                examimg.setImageResource(values[0]);
                view1.setText(values[1].toString());
                progressBar.setProgress(values[1]);



        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            view1.setText("Result:"+s);
        }
    }
}

package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class HandlerExam extends AppCompatActivity {
    TextView textView;
    Handler handler21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        textView = findViewById(R.id.text21);
        handler21 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                textView.setText(msg.arg1+"");
            }
        };
    }
    public void useA3Handler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=10; i++){
                    Message msg = new Message();
                    msg.arg1=i;
                    handler21.sendMessage(msg);
                    SystemClock.sleep(100);
                }
            }
        }).start();

    }
}

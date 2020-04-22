package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Logo extends AppCompatActivity {
    Handler handler;
    //5초후에 처리해야하는 작업을 쓰레드로 정의
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Logo.this,HandlerExam2.class);
            startActivity(intent);
            finish();
            //메인 액티비티로 전환될때 애니메이션 효과를 추가 할 수 있다
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        handler = new Handler();
        handler.postDelayed(runnable,5000);
    }
}

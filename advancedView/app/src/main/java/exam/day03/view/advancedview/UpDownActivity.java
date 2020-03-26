package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class UpDownActivity extends AppCompatActivity {
    ImageView img01 ;
    ImageView img02 ;
    int index1=1;
    int index2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updown_test);
        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
    }
    public void myClickUp(View v) {
        imageUp();
    }
    public void myClickDown(View v) {
        imageDown();
    }
    public void imageUp(){

            img01.setVisibility(View.VISIBLE);
            //1번은 화면에 보이지 않도록 설정
            img02.setVisibility(View.INVISIBLE);



    }
    public void imageDown(){

            img01.setVisibility(View.INVISIBLE);
            //1번은 화면에 보이지 않도록 설정
            img02.setVisibility(View.VISIBLE);


    }
}

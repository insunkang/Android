package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.FirstFragment;
import multi.android.support_lib.fragment.SecondFragment;

public class ExamFragmentMain extends AppCompatActivity {
    FirstExamFragment firstExamFragment = new FirstExamFragment();
    SecondExamFragment secondExamFragment = new SecondExamFragment();
    ThirdExamFragment thirdExamFragment = new ThirdExamFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);
        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setFragment("first");
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setFragment("second");
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setFragment("third");
//            }
//        });
    }

    public void btn_click(View view){
        setFragment(view.getTag().toString());
    }
    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프래그먼트의 변화를 관리하는 객체
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (idx){
            case "0":
                transaction.replace(R.id.container,firstExamFragment);
                break;
            case "1":
                transaction.replace(R.id.container,secondExamFragment);
                break;
            case "2":
                transaction.replace(R.id.container,thirdExamFragment);
                break;


        }
        transaction.commit();
    }
//    public void setFragment(String name){
//        //fragment객체를 관리하는 관리자 객체를 구한다.
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        //fragment작업을 시작하기 위한 트랜잭션객체를 구한다.
//        FragmentTransaction transaction= fragmentManager.beginTransaction();
//        switch (name){
//            case "first":
//                transaction.replace(R.id.container,firstExamFragment);
//                break;
//            case "second":
//                transaction.replace(R.id.container,secondExamFragment);
//                break;
//            case "third" :
//                transaction.replace(R.id.container,thirdExamFragment);
//                break;
//        }
//        transaction.commit();
//
//    }
}

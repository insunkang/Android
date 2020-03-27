package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class FrameTest extends AppCompatActivity {
    LinearLayout loginlayout;
    LinearLayout signinlayout;
    LinearLayout detaillayout;
    EditText loginarea1;
    EditText loginid;
    EditText loginpass;

    EditText signinarea1;
    EditText signinname;
    EditText signinid;
    EditText signinpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);

        loginlayout = findViewById(R.id.loginmenu);
        signinlayout = findViewById(R.id.signinmenu);
        detaillayout = findViewById(R.id.detailmenu);

        Button login = findViewById(R.id.loginmenubtn);
        final Button signin = findViewById(R.id.signinmenubtn);
        Button detail = findViewById(R.id.detailmenubtn);

        Button loginbtn = findViewById(R.id.loginbtn);
        Button signinbtn = findViewById(R.id.signinbtn);

        loginarea1 = findViewById(R.id.logintext);
        loginid = findViewById(R.id.loginid);
        loginpass = findViewById(R.id.loginpass);

        signinarea1 = findViewById(R.id.signintext);
        signinname = findViewById(R.id.signname);
        signinid = findViewById(R.id.signid);
        signinpass = findViewById(R.id.signpass);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginarea1.append(loginid.getText()+"\n");
                loginarea1.append(loginpass.getText());
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinarea1.append(signinname.getText()+"\n");
                signinarea1.append(signinid.getText()+"\n");
                signinarea1.append(signinpass.getText());
            }
        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginarea1.setText("");
//
//               loginlayout.setVisibility(View.VISIBLE);
//               signinlayout.setVisibility(View.INVISIBLE);
//               detaillayout.setVisibility(View.INVISIBLE);
//            }
//        });
//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signinarea1.setText("");
//
//                loginlayout.setVisibility(View.INVISIBLE);
//                signinlayout.setVisibility(View.VISIBLE);
//                detaillayout.setVisibility(View.INVISIBLE);
//            }
//        });
//        detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginlayout.setVisibility(View.INVISIBLE);
//                signinlayout.setVisibility(View.INVISIBLE);
//                detaillayout.setVisibility(View.VISIBLE);
//            }
//        });
        //Button이 클릭될때 호출되는 메소드 = View.onClickListener의
        //public void onClick(View v)메소드와 동일한 역할


    }
    public void myClick(View v){
        if(v.getId()==R.id.loginmenubtn){
            loginlayout.setVisibility(View.VISIBLE);
            signinlayout.setVisibility(View.INVISIBLE);
            detaillayout.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.signinmenubtn){
            loginlayout.setVisibility(View.INVISIBLE);
            signinlayout.setVisibility(View.VISIBLE);
            detaillayout.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.detailmenubtn){
            loginlayout.setVisibility(View.INVISIBLE);
            signinlayout.setVisibility(View.INVISIBLE);
            detaillayout.setVisibility(View.VISIBLE);
        }
    }

}

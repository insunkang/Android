package exam.day04.view.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ExamSecondActivity extends AppCompatActivity{
    Button ok;
    TextView result;
    CheckBox memberState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);
        result = findViewById(R.id.exam_result_txt);
        ok = findViewById(R.id.exam_close);
        memberState= findViewById(R.id.member_state);

        final Intent intent = getIntent();

        String id = intent.getStringExtra("name");
        if (id ==null){
            User dto = intent.getParcelableExtra("dto");
            result.setText(dto.name+","+dto.getTelNum());
        }else{
            String tel = intent.getStringExtra("tel");
            result.setText("입력한 id:"+id+",입력한 전화번호:"+tel);
        }



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("chkVal",memberState.isChecked());
                setResult(RESULT_OK,intent);
                finish();
            }
        });




    }



}

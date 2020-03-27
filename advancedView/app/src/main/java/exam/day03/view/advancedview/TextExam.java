package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextExam extends AppCompatActivity {
    TextView lblinfo;
    EditText chatinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_exam);

        Button btnsender = findViewById(R.id.send);
        chatinfo = findViewById(R.id.msg);
        lblinfo = findViewById(R.id.chat);
        btnsender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chat =chatinfo.getText()+"";
                lblinfo.setText(chat);
            }
        });
    }
}

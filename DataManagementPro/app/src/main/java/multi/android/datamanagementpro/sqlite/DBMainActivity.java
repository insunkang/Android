package multi.android.datamanagementpro.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;


public class DBMainActivity extends AppCompatActivity {
    EditText id;
    EditText name;
    EditText age;
    TextView result;
    DBHelper dbHelper ; //데이터 베이스 파일생성, 테이블 생성....
    SQLiteDatabase db ; //로컬 디비 연동을 위한 핵심 클래스
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbjob_main);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        result = findViewById(R.id.result);

        //1. DBHelper생성
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        //2. SQLiteDatabase객체 생성
    }
    public void insert(View v){
        String sql = "insert into member(id,name,age) values(?,?,?)";
        db.execSQL(sql, new String[]{id.getText().toString(),
                                     name.getText().toString(),
                                        age.getText().toString()});
        Toast.makeText(this,"삽입성공",Toast.LENGTH_LONG).show();
    }
    public void delete(View v){
        String sql = "select * from member";
        Cursor cursor = db.rawQuery(sql,null );


        String sql1 = "delete from member where id = ?";
        db.execSQL(sql1, new String[]{id.getText().toString()});
    }
    public void update(View v){
        String sql = "update member set age = ? where id =?";
        db.execSQL(sql, new String[]{age.getText().toString(),
                id.getText().toString()});
        Toast.makeText(this,"수정성공",Toast.LENGTH_LONG).show();
    }
    public void selectAll(View v){
        String sql = "select * from member";
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();//레코드 갯수를 반환
        Toast.makeText(this,"조회된 row"+count,Toast.LENGTH_LONG).show();
        while (cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);
            result.append("번호:"+idx+"\n"+
                    "아이디:"+id+"\n"+
                    "성명:"+name+"\n"+
                    "나이:"+age+"\n"+
                    "==========================\n");
        }
    }

}

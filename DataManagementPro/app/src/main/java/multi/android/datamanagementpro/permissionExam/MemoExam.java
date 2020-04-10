package multi.android.datamanagementpro.permissionExam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class MemoExam extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    EditText editText;
    boolean permission_state1;
    boolean permission_state2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_exam);
        editText = findViewById(R.id.editTxt);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED
        ){
            permission_state1 = true;

            printToast("권한이 설정되었습니다.");


        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED
        ){
            permission_state1 = true;

            printToast("권한이 설정되었습니다.");


        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2000);
        }



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOpen(v);
            }
        });
    }

    private void runOpen(View v) {
        if (permission_state1==true){
            printToast("권한설정완료");
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)){
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = external.getAbsolutePath()+"/myApp";
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성
                //=> 앱을 삭제하면 데이터가 같이 삭제된다.
                String dirPath = external.getAbsolutePath();
                String pkg =getPackageName();


                File dir = new File(dirPath+"/mynote");
                //디렉토리 없으면 생성

                // File dir = new File(dirPath);
                if (!dir.exists()){
                    dir.mkdir();
                }

                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/_memo.txt");
                    fw.write(editText.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                printToast("사용불가능");
            }

        }else{

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)){
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = external.getAbsolutePath()+"/myApp";
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성
                //=> 앱을 삭제하면 데이터가 같이 삭제된다.
                String dirPath = external.getAbsolutePath();
                String pkg =getPackageName();


                File dir = new File(dirPath+"/mynote");
                //디렉토리 없으면 생성

                // File dir = new File(dirPath);
                if (!dir.exists()){
                    dir.mkdir();
                }

                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/_memo.txt");
                    fw.write(editText.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                printToast("사용불가능");
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000&&grantResults.length>0) {//권한의 성공 설정에 대한 결과가 있다는 의미
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permission_state1 = true;
                printToast("WRITE권한 설정 완료");


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }
        if (requestCode==2000&&grantResults.length>0){//권한의 성공 설정에 대한 결과가 있다는 의미
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state2=true;
                printToast("READ권한 마무리 완료");

            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2000);
                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }
    }

    private void printToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }


}

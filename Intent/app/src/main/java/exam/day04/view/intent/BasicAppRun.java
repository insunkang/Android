package exam.day04.view.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.PeriodicSync;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

public class BasicAppRun extends AppCompatActivity {
    //승인 받을 권한의 목록
    String[] permission_list={
            Manifest.permission.CALL_PHONE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_app_run);

        //권한체크 메소드를 호출
        runPermission();
    }
    //구글맵실행
    public  void runGoogleMap(View v){
        Uri uri = Uri.parse("geo:27.21,126.8632");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //웹브라우저실행
    public  void runWeb(View v){
        Uri uri = Uri.parse("https://www.daum.net");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public  void runDial(View v){
        Uri uri = Uri.parse("tel:00000000");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    //실제 전화 걸기 위한 메소드
    public void runCallPhone(View v){
        Intent intent = null;
        int chk = PermissionChecker.checkSelfPermission(this,Manifest.permission.CALL_PHONE);
        if (chk==PackageManager.PERMISSION_GRANTED){
            Log.d("tel","성공");
            intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:5556"));

        }else{
            Log.d("tel","실패");
            return;
        }
        startActivity(intent);
    }
    public void runPermission(){
        //하위버전이면 실행되지 않도록 처리
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return;
        }
        //모든 권한을 셀프체크
        for (String permission:permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list,0);
                break;
            }
        }
    }
}

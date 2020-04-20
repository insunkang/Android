package multi.android.map_location_pro.loaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multi.android.map_location_pro.R;

//현재 위치정보를 가져와서 맵에 연결해서 출력 - avd, device
public class LocationMapExam extends AppCompatActivity implements LocationListener,
        OnMapReadyCallback, GoogleMap.OnCameraMoveListener {
    LocationManager locationManager;
    TextView result;
    GoogleMap map;
    boolean permission_state;
    List<String> provider_list; //전체 위치 제공자 목록
    List<String> enableProvider_list; //사용 가능한 위치 제공자 목록
    LatLng myloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map_exam);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment) manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (ContextCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED | ContextCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            printToast("권한이 없습니다.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
        } else {
            permission_state = true;
            printToast("권한을 설정했습니다.");
            //권한 설정이 완료되면 Provider목록을 가져와서 출력



            getLocation();
            getProviderlist();
        }
    }
    public void getLocation(){
        for (String provider:enableProvider_list){
            Location location = null;
            try {
                location = locationManager.getLastKnownLocation(provider);
                if (location!=null){
                    //위치정보(위도,경도,고도..)
                    printInfo(provider,location);
                    locationManager.requestLocationUpdates(provider,3000,1,this);
                }
                Log.d("msg","==========성공==========");
            }catch (SecurityException e){
                Log.d("msg","======"+e.getMessage()+"=====");
            }


        }
    }
    public void getProviderlist(){
        String msg = "모든 provider list ..";
        //제공되는 모든 provider목록을 가져오기
        provider_list = locationManager.getAllProviders();
        Log.d("msg", provider_list.size()+"");
        for (String provider:provider_list){
            msg = msg+"\n"+provider+"\n";
        }
//        result.setText(msg);
        //사용가능한 목록
        enableProvider_list =locationManager.getProviders(true);
        Log.d("msg", enableProvider_list.size()+"");
        msg=msg+"사용가능한 목록........\n";
        for (String provider:enableProvider_list){
            msg = msg+"\n"+provider+"\n";
        }
        result.append(msg+"\n");
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000&&grantResults.length>0){//권한의 성공 설정에 대한 결과가 있다는 의미
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED
                    &grantResults[1]==PackageManager.PERMISSION_GRANTED){
                permission_state=true;
                printToast("권한 설정 마무리 완료");
            }else{

                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }

    }
    public void printInfo(String provider, Location location){
        //String msg = "";
        if (location!=null){
            result.append("==============="+provider+"===============");
            result.append("Latitude=>"+location.getLatitude()+"\n");
            result.append("Longitude=>"+location.getLongitude()+"\n");

            Date date = new Date(location.getTime());
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm");
            result.append("시간:"+simpleDateFormat.format(date)+"\n");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //LatLng latLng = new LatLng(getLocation(),getLocation());

        if(map!=null){
            //위도,경도지정

            //지도 확대축소버튼을 추가
            map.getUiSettings().setZoomControlsEnabled(true);
            //현재 나의 위치를 포인트로 표시
            // - 위치기반서비스에 대한 퍼미션체크가 완료되어야 표시
            map.getUiSettings().setZoomControlsEnabled(true);
         //   map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        }
    }


    private void printToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {

        String provider = location.getProvider(); //현재 정보를 제공하는 Provider


    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onCameraMove() {

    }
    ///////////

}

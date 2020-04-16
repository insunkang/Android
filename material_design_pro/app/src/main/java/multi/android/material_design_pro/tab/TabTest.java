package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.FirstExamFragment;
import multi.android.material_design_pro.exam.ListTestFragment;
import multi.android.material_design_pro.exam.ThirdExamFragment;

public class TabTest extends AppCompatActivity {
    FirstExamFragment firstExamFragment;
    ListTestFragment secondExamFragment;
    ThirdExamFragment thirdExamFragment;
    ArrayList<Fragment> fragmentArrayList ;

    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        firstExamFragment = new FirstExamFragment();
        secondExamFragment = new ListTestFragment();
        thirdExamFragment = new ThirdExamFragment();
        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭 추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할때 보여줄 프레그먼트 지정
        getSupportFragmentManager().beginTransaction().
                replace(R.id.contents_container,firstExamFragment).commit();
        //탭에 이벤트 연결하기
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭이 선택될때 호출되는 메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position= tab.getPosition();
                Log.d("tab",position+"");
                Fragment fragment ;
                if (position==0){
                    fragment=firstExamFragment;
                }else if (position==1){
                    fragment=secondExamFragment;
                }else {
                    fragment=thirdExamFragment;
                }
                //탭을 선택할 때 지정된 프레그먼트 객체가 show되도록 연결
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.contents_container,fragment).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.contents_container,secondExamFragment).commit();
                }
                return false;
            }
        });
    }
}

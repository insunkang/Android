package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;

public class ExamFragmentMain extends AppCompatActivity {
    FirstExamFragment firstExamFragment = new FirstExamFragment();
    //SecondExamFragment secondExamFragment = new SecondExamFragment();
    ListTestFragment secondExamFragment = new ListTestFragment();
    ThirdExamFragment thirdExamFragment = new ThirdExamFragment();
    MapFragment mapFragment = new MapFragment();

    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);


        fragmentArrayList.add(firstExamFragment);
        fragmentArrayList.add(secondExamFragment);
        fragmentArrayList.add(thirdExamFragment);
        fragmentArrayList.add(mapFragment);
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
    }
    public void btn_click(View view){
       fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }
   /* public void setFragment(String idx){
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
    }*/
    class FragAdapter extends FragmentStatePagerAdapter{

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
    }
    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(ExamFragmentMain.this,"페이지가 전환",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
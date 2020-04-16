package multi.android.material_design_pro.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.tab.ChildBlankFragment;


public class ExamFragmentMain extends AppCompatActivity {
    FirstExamFragment firstExamFragment = new FirstExamFragment();
    //SecondExamFragment secondExamFragment = new SecondExamFragment();
    ListTestFragment secondExamFragment = new ListTestFragment();
    ThirdExamFragment thirdExamFragment = new ThirdExamFragment();

    TabLayout tabLayout;
    ViewPager fragment_viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    String[] tab_txt = {"추천여행지","춪게","나의혀앻잊"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        tabLayout = findViewById(R.id.examtab);

        fragmentArrayList.add(firstExamFragment);
        fragmentArrayList.add(secondExamFragment);
        fragmentArrayList.add(thirdExamFragment);

        tabLayout.setTabTextColors(Color.BLACK,Color.BLACK);


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),
                fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
        tabLayout.setupWithViewPager(fragment_viewPager);
    }
    class PagerAdapter extends FragmentStatePagerAdapter{

        public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
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
        //뷰페이저와 탭을 연결하기 위해서 텝에 출력될 문자열을 만들어내는 메소드
        //setupWithViewPager메소드 내부에서 탭의 문자열을 출력하기 위해서 호출한다.
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_txt[position];
        }
    }









    public void btn_click(View view){
       fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }



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
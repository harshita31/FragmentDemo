package com.example.harshita.fragmentdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFragment(new FragmentOne(),"One");
        vpa.addFragment(new FragmentTwo(),"Two");
        viewPager.setAdapter(vpa);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList=new ArrayList<>();
        private final List<String> fragmenttitleList=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public  void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmenttitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmenttitleList.get(position);
        }
    }

}

package com.peakhe.www.assimplebook;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.peakhe.www.assimplebook.fragment.FindFragment;
import com.peakhe.www.assimplebook.fragment.HomePageFragment;
import com.peakhe.www.assimplebook.fragment.MineFragment;
import com.peakhe.www.assimplebook.fragment.ReleaxFragment;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    //Tab 文字
    private final int[] TAB_TITLES = new int[]{R.string.homepage,R.string.find,R.string.release,R.string.mine};
    //Tab 图片
    private final int[] TAB_IMGS = new int[]{R.drawable.tab_homepage_selector,R.drawable.tab_find_selector,R.drawable.tab_releax_selector,R.drawable.tab_mine_selector};
    private HomePageFragment home_page;
    private  FindFragment find;
    private ReleaxFragment releax;
    private MineFragment mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout =(TabLayout) findViewById(R.id.tablelayout);
        initViews();
        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        home_page = new HomePageFragment();
        transaction.add(R.id.fmlayout,home_page,"homepage");
        transaction.commit();
    }
    private  void setHide(Fragment fm, FragmentTransaction action){

        if(fm != null && action != null)
            action.hide(fm);

    }
    private  void setShow(Fragment fm, FragmentTransaction action){
        if(fm != null && action != null)
            action.show(fm).commit();
    }
    private void initViews() {
        setTabs(mTabLayout,this.getLayoutInflater(),TAB_TITLES,TAB_IMGS);

    /*    mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));*/
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (tab.getPosition()){
                    case 0:

                            setHide(find,transaction);
                            setHide(releax,transaction);
                            setHide(mine,transaction);
                            setShow(home_page,transaction);

                        break;
                    case 1:
                        if(find ==null){
                            find = new FindFragment();
                            transaction.add(R.id.fmlayout,find,"find");
                        }
                        setHide(home_page,transaction);
                        setHide(releax,transaction);
                        setHide(mine,transaction);
                        setShow(find,transaction);


                        break;
                    case 2:
                        if(releax ==null){
                            releax = new ReleaxFragment();
                            transaction.add(R.id.fmlayout,releax,"releax");
                        }
                        setHide(find,transaction);
                        setHide(home_page,transaction);
                        setHide(mine,transaction);
                        setShow(releax,transaction);


                        break;
                    case 3:
                        if (mine == null) {
                            mine = new MineFragment();
                            transaction.add(R.id.fmlayout,mine,"mine");
                        }
                        setHide(find,transaction);
                        setHide(releax,transaction);
                        setHide(home_page,transaction);
                        setShow(mine,transaction);
                        break;
                    default:

                }
              //  Toast.makeText(MainActivity.this, "select tab = "+tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

/*             @Override

           public voidonTabSelected(TabLayout.Tab tab) {

//选中了tab的逻辑

            }

            @Override

            public voidonTabUnselected(TabLayout.Tab tab) {

//未选中tab的逻辑

            }

            @Override

            public voidonTabReselected(TabLayout.Tab tab) {

//再次选中tab的逻辑

            }*/

        });
    }
    /**
     * @description: 设置添加Tab
     */
    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitlees, int[] tabImgs) {
        for (int i = 0; i < tabImgs.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.custom, null);
            tab.setCustomView(view);

            TextView tvTitle = (TextView) view.findViewById(R.id.tv_tab);
            tvTitle.setText(tabTitlees[i]);
            ImageView imgTab = (ImageView) view.findViewById(R.id.img_tab);
            imgTab.setImageResource(tabImgs[i]);
            tabLayout.addTab(tab);

        }
    }
}

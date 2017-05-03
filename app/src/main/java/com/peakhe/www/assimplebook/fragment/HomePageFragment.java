package com.peakhe.www.assimplebook.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.peakhe.www.assimplebook.R;
import com.peakhe.www.assimplebook.adapter.HomePageAdapter;
import com.peakhe.www.assimplebook.fragment.ui.FlowLayout;

/**
 * Created by Administrator on 2017/4/30 0030.
 */

public class HomePageFragment extends Fragment {
    private  SwipeRefreshLayout swiperefresh;
    private String[] mVals = new String[] { "苹果手机", "笔记本电脑", "电饭煲 ", "腊肉",
            "特产", "剃须刀", "宝宝", "康佳","苹果手机", "笔记本电脑", "电饭煲 ", "腊肉",
            "特产", "剃须刀", "宝宝", "康佳" };
    private LayoutInflater mInflater;
    private FlowLayout mFlowLayout;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepagefragment,container,false);
        mInflater = LayoutInflater.from(getActivity());
        mFlowLayout = new FlowLayout(getActivity());
       // initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView recyler = (RecyclerView) view.findViewById(R.id.recycler_homepage);
        recyler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyler.setAdapter(new HomePageAdapter(getActivity(),mVals));
          swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh_homepage);
        //改变加载显示的颜色
        swiperefresh.setColorSchemeColors(getResources().getColor(R.color.app_color),getResources().getColor(R.color.app_color));
        //设置背景颜色
        //swiperefresh.setBackgroundColor(Color.YELLOW);
        //设置初始时的大小
        //swiperefresh.setSize(SwipeRefreshLayout.LARGE);
        //设置向下拉多少出现刷新
        swiperefresh.setDistanceToTriggerSync(100);
        //设置刷新出现的位置
        swiperefresh.setProgressViewEndTarget(false, 100);
        //滑动监听
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //然刷新控件停留两秒后消失
                            Thread.sleep(2000);
                            handler.post(new Runnable() {//在主线程执行
                                @Override
                                public void run() {
                                    //更新数据
                                  //  adapter.notifyDataSetChanged();
                                    //停止刷新
                                    swiperefresh.setRefreshing(false);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    public void initData() {
        /**
         * 找到搜索标签的控件
         */
        for (int i = 0; i < mVals.length; i++) {
            TextView tv = (TextView) mInflater.inflate(
                    R.layout.search_label_tv, mFlowLayout, false);
          /*  TextView tv1 = new TextView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(getActivity(),);*/

            tv.setText(mVals[i]);
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);
        }
    }
}

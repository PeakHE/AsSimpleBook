package com.peakhe.www.assimplebook.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.peakhe.www.assimplebook.R;
import com.peakhe.www.assimplebook.fragment.ui.FlowLayout;

/**
 * Created by Administrator on 2017/4/30 0030.
 */

public class ReleaxFragment extends Fragment {
    private String[] mVals = new String[] { "苹果手机", "笔记本电脑", "电饭煲 ", "腊肉",
            "特产", "剃须刀", "宝宝", "康佳","苹果手机", "笔记本电脑", "电饭煲 ", "腊肉",
            "特产", "剃须刀", "宝宝", "康佳" };
    private LayoutInflater mInflater;
    private FlowLayout mFlowLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.releaxfragment,container,false);
        mInflater = LayoutInflater.from(getActivity());
        mFlowLayout = (FlowLayout) view.findViewById(R.id.flowlayout);
        initData();
        return view;
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

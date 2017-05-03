package com.peakhe.www.assimplebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.peakhe.www.assimplebook.R;
import com.peakhe.www.assimplebook.fragment.ui.FlowLayout;
import com.peakhe.www.assimplebook.imp.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import static com.peakhe.www.assimplebook.R.layout.banner;

/**
 * Created by Administrator on 2017/5/1 0001.
 */

public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  static final int  TYPE_ADT = 0;
    private  static final int  TYPE_FLOW = 1;
    private  static final int  TYPE_NOR = 2;
    private  LayoutInflater mLayoutInflater;
    private  String[] titles;
    private  Context context;
    private FlowLayout mFlowLayout;
    private Banner mBanner;

    public HomePageAdapter(Context context, String[] titles){
        this.titles = titles;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                return new AdvertHolder(mLayoutInflater.inflate(R.layout.item_adavert_homepage,parent,false));
            case 1:
                return new FlowHolder(mLayoutInflater.inflate(R.layout.item_flow_homepage,parent,false));
            case 2:
                return new NormalHolder(mLayoutInflater.inflate(R.layout.item_normal_homepage,parent,false));
        }
        return  new NormalHolder(mLayoutInflater.inflate(R.layout.item_normal_homepage,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AdvertHolder){
            List<Integer> images;
            images = new ArrayList<Integer>();
            images.add(R.mipmap.ic_launcher);
            images.add(R.mipmap.ic_launcher);
            images.add(R.mipmap.ic_launcher);
            images.add(R.drawable.tab_mine_normal);

            mBanner = ((AdvertHolder) holder).banner;
            mBanner.setImages(images).setImageLoader(new GlideImageLoader()).start();
        }

        if(holder instanceof FlowHolder){
            mFlowLayout=((FlowHolder) holder).flowlayout;
            initData(titles);
        }

        if(holder instanceof NormalHolder){


        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return TYPE_ADT;
            case 1 :
                return  TYPE_FLOW;
            default:
                return TYPE_NOR;
        }
    }

    @Override
    public int getItemCount() {
        return  titles == null ? 0 : titles.length;
    }
    public void initData(String[] mVals ) {
        /**
         * 找到搜索标签的控件
         */
        for (int i = 0; i < mVals.length; i++) {
            TextView tv = (TextView) mLayoutInflater.inflate(
                    R.layout.search_label_tv, mFlowLayout, false);
          /*  TextView tv1 = new TextView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(getActivity(),);*/

            tv.setText(mVals[i]);
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);
        }
    }


    class  NormalHolder extends RecyclerView.ViewHolder{

        public NormalHolder(View itemView) {
            super(itemView);
        }
    }

     class  FlowHolder extends  RecyclerView.ViewHolder{
         FlowLayout flowlayout;
        public FlowHolder(View itemView) {
            super(itemView);
            flowlayout= (FlowLayout) itemView.findViewById(R.id.item_flowlayout);
        }
    }
    class AdvertHolder extends  RecyclerView.ViewHolder{
        private Banner banner;
        public AdvertHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner) ;
        }
    }
}

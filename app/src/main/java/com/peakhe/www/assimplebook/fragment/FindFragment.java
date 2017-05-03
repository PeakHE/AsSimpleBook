package com.peakhe.www.assimplebook.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peakhe.www.assimplebook.R;

/**
 * Created by Administrator on 2017/4/30 0030.
 */

public class FindFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.findfragment,container,false);
        return view;
    }
}

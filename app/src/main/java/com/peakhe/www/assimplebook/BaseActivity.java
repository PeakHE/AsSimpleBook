package com.peakhe.www.assimplebook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/4/29 0029.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        AppContext.getInstance().AddActicty(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppContext.getInstance().RemoveActivity(this);

    }
}

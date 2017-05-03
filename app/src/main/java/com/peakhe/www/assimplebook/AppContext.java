package com.peakhe.www.assimplebook;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29 0029.
 */

public class AppContext extends Application {
    private static AppContext instance;
    private  static List<Activity>activities = new ArrayList<Activity>();
    public static  AppContext getInstance(){
     return  instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public void AddActicty(Activity activity){
        if(activities !=null)
        activities.add(activity);
    }
    public  void RemoveActivity(Activity activity){
        if(activities != null)
            activities.remove(activity);
    }
}

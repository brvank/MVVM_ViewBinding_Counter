package com.example.mvvm.Util;

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppApplication.mContext = getApplicationContext();
    }

    public static Context getContext(){
        return AppApplication.mContext;
    }
}

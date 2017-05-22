package com.example.my_pulltorefresh_github.application;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc:
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}

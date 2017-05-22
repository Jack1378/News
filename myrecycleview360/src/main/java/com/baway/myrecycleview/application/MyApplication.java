package com.baway.myrecycleview.application;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/17 20:57
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}

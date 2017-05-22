package com.example.newsdemo.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by cj on 2017/5/9.
 */

public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        PlatformConfig.setQQZone("1106086767", "pC2wfXv6quTcZgPg");
        UMShareAPI.get(this);
    }
}

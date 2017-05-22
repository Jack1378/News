package com.example.mysharedemo;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * name ：李飞宇
 * Date: 2017/5/17
 * desc:
 */

public class application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("1106086767", "pC2wfXv6quTcZgPg");
        UMShareAPI.get(this);
    }
}

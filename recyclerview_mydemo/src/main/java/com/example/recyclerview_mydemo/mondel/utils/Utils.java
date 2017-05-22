package com.example.recyclerview_mydemo.mondel.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc:
 */

public class Utils {
    public static <T> void getData(String url, HashMap<String, String> hashMap, final CallBackHome callBackHome, final Class<T> t) {
        RequestParams params = new RequestParams();
        params.setUri(url);
        if (hashMap != null) {
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String values = hashMap.get(key);
                params.addQueryStringParameter(key, values);
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                T t1 = gson.fromJson(result, t);
                callBackHome.callBack(t1);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public interface CallBackHome<T> {
        void callBack(T t);
    }
}

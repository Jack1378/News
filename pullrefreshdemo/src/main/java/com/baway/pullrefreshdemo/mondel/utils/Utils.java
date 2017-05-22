package com.baway.pullrefreshdemo.mondel.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/19 15:42
 */

public class Utils {

    public static <T>void getUtils(String url, final CallHomeBack callHomeBack, final Class<T> t){
        RequestParams params = new RequestParams();
        params.setUri(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                T t1 = gson.fromJson(result, t);
                callHomeBack.callHome(t1);
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

    public interface CallHomeBack<T> {
        void callHome(T t);
    }
}

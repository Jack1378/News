package com.example.my_pulltorefresh_github.modle.bean.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 加载数据的工具类  使用xutils 加载数据
 */

public class Utils {
    //方法里的参数是逻辑里传过来的 url 网址数据  定义的一个方法
    public static <T> void getUtils(String url, final CalllHomeBack calllhomeBack, final Class<T> clazz) {
        RequestParams params = new RequestParams();
        params.setUri(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                T t = gson.fromJson(result, clazz);
                //把解析的数据传入到接口里
                calllhomeBack.calllhomeBack(t);
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

    //自定义一个接口  在本类里调用 把解析的数据值传过来
    public interface CalllHomeBack<T> {
        void calllhomeBack(T t);
    }
}

package com.example.newsdemo.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.example.newsdemo.modle.utils.HttpUtils;
import com.example.newsdemo.view.iview.IHomeView;
import com.example.newsdemo.view.iview.IMvpView;

import org.xutils.x;

import java.util.HashMap;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc:
 */

public class HomePresenter extends BasePresenter<IHomeView> {
    private String url = "http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news";
    private HashMap<String,String>hashMap = new HashMap<>();

    public void getImageFormServer(ImageView imageView,String url){
        x.image().bind(imageView, url);
    }
    public <T> void getHomeDataFromServer(Class<T> t){
        HttpUtils.getTestData(url,hashMap,new HttpUtils.CallbackVideoData<T>(){

            @Override
            public void callback(T t) {
                    getT().callbackStr(t);
            }
        },t);
    }

}

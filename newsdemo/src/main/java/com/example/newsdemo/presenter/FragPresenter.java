package com.example.newsdemo.presenter;

import android.util.Log;
import android.widget.ImageView;

import com.example.newsdemo.modle.utils.HttpUtils;
import com.example.newsdemo.view.iview.IFragView;

import org.xutils.x;

import java.util.HashMap;

/**
 * name ：李飞宇
 * Date: 2017/5/13
 * desc:
 */

public class FragPresenter extends BasePresenter<IFragView> {
    private String url = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=";
    private HashMap<String, String> hashMap = new HashMap<>();


    public void getFragImageFormServer(ImageView imageView, String url) {
        x.image().bind(imageView, url);
    }

    public <T> void getFragDataFromServer(Class<T> t,String pa){
        HttpUtils.getTestData(url+pa,hashMap,new HttpUtils.CallbackVideoData<T>(){
            @Override
            public void callback(T t) {
                if (getT() != null){
                    getT().fragcallbackstr(t);
                }else {
                    Log.e("FragPresenter","请调用 attachView ");
                }
            }
        },t);
    }


}

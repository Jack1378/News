package baway.com.cj.mvptest1503a.presenter;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import baway.com.cj.mvptest1503a.model.utils.HttpUtils;
import baway.com.cj.mvptest1503a.model.video.VideoBean;
import baway.com.cj.mvptest1503a.view.iview.IVideoView;

/**
 * Created by cj on 2017/5/10.
 */

public class VideoPresenter extends BasePresenter<IVideoView> {
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/2/p/1";
    private HashMap<String, String> hashMap = new HashMap<>();


    public <T> void getVideoData(final Class<T> classOfT) {
        HttpUtils.getTestData(url,hashMap, new HttpUtils.CallbackVideoData<T>() {
            @Override
            public void callback(T t) {
                getMvpView().getVideoBean(t);
            }
        }, classOfT);
    }



}

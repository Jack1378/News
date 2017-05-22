package baway.com.cj.mvptest1503a.presenter;

import android.util.Log;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import baway.com.cj.mvptest1503a.model.utils.HttpUtils;
import baway.com.cj.mvptest1503a.view.iview.IHomeView;

/**
 * Created by cj on 2017/5/9.
 */

public class HomePresenter extends BasePresenter<IHomeView> {
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/2/p/1";
    private HashMap<String, String> hashMap = new HashMap<>();


    public void getImageFormServer(ImageView imageView, String url) {
        x.image().bind(imageView, url);
    }

    public <T> void getHomeDataFromServer(Class<T> t) {
        HttpUtils.getTestData(url, hashMap, new HttpUtils.CallbackVideoData<T>() {
            @Override
            public void callback(T t) {
                if (getMvpView() != null) {
                    getMvpView().callbackStr(t);
                } else {
                    Log.e("HomePresenter","请调用 attachView ");
                }
            }
        }, t);
    }

    public void uploadImage(String url,String filePath) {
        RequestParams params = new RequestParams(url);

        //params.setAsJsonContent(true);
        List<KeyValue> list = new ArrayList<>();
        list.add(new KeyValue("file", new File(filePath)));
        //list.add(new KeyValue("parameters", json.toString()));
        MultipartBody body = new MultipartBody(list, "UTF-8");
        params.setMultipart(true);
        params.setRequestBody(body);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("myMessage"," "+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("myMessage"," "+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}

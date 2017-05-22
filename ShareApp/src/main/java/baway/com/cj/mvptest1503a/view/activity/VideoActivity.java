package baway.com.cj.mvptest1503a.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import baway.com.cj.mvptest1503a.model.video.VideoBean;
import baway.com.cj.mvptest1503a.presenter.VideoPresenter;
import baway.com.cj.mvptest1503a.view.iview.IVideoView;

/**
 * Created by cj on 2017/5/10.
 */

public class VideoActivity extends Activity implements IVideoView<VideoBean>{

    private VideoPresenter videoPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        videoPresenter = new VideoPresenter();
        videoPresenter.attachView(this);
        videoPresenter.getVideoData(VideoBean.class);
    }

    @Override
    public void getVideoBean(VideoBean videoBean) {

    }
}

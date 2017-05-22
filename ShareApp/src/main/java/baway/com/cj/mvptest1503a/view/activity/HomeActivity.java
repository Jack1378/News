package baway.com.cj.mvptest1503a.view.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import baway.com.cj.mvptest1503a.R;
import baway.com.cj.mvptest1503a.model.home.HomeBean;
import baway.com.cj.mvptest1503a.presenter.HomePresenter;
import baway.com.cj.mvptest1503a.view.adapter.HomeAdapter;
import baway.com.cj.mvptest1503a.view.iview.IHomeView;

public class HomeActivity extends AppCompatActivity implements IHomeView<HomeBean>{

    private HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    private ListView listView;
    private String uploadUrl = "http://169.254.159.111:8080/ssm/user/photoUpload";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void initData() {
        homePresenter = new HomePresenter();
        // this == HomeActivity
        homePresenter.attachView(this);
        homeAdapter = new HomeAdapter(this);
        homeAdapter.setPresenter(homePresenter);
        listView.setAdapter(homeAdapter);
        //homePresenter.getHomeDataFromServer(HomeBean.class);
        String upUrl = Environment.getExternalStorageDirectory().getAbsolutePath()+"/pic/hh.png";
        Log.e("myMessage"," upUrl= " +upUrl );
        homePresenter.uploadImage(uploadUrl,upUrl);
    }

    @Override
    public void callbackStr(HomeBean data) {
        homeAdapter.setData(data.getData());
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void callbackErr(String errMsg, int errCode) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.example.newsdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.tool.UiUtils;
import com.example.newsdemo.view.activity.MainActivity;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc:
 */

public class Fragment_4 extends Fragment {
    private static final String TAG = "Fragment_4";
    private static final String APP_ID = "1106087545";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    private ImageView image_qq;
    private View view;
    private RadioButton RadioButton_night;
    private ImageView image_phone;
    private TextView tv_register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_4, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTencent = Tencent.createInstance(APP_ID, getActivity());
        SMSSDK.initSDK(getActivity(), "1ddc10f38ea8c", "3cb78ea2243a9645dfe87c73ce792857");
        initView();
        click();
    }

    private void initView() {
        //传入参数APPID和全局Context上下文
        image_qq = (ImageView) getView().findViewById(R.id.Image_QQ);
        RadioButton_night = (RadioButton) getView().findViewById(R.id.RadioButton_night);
        image_phone = (ImageView) getView().findViewById(R.id.Image_phone);
        tv_register = (TextView) getView().findViewById(R.id.tv_register);
    }


    //点击事件
    private void click() {
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMWeb web = new UMWeb("https://www.baidu.com/");
                web.setTitle("This is music title\");//标题\n" +
                        "                //web.setThumb(thumb);  //缩略图\n" +
                        "                web.setDescription(\"my description");//描述
                Toast.makeText(getActivity(), " 分享成功啦", Toast.LENGTH_SHORT).show();
                new ShareAction(getActivity()).setPlatform(SHARE_MEDIA.QQ)
                        .withMedia(web)
                        .withText("hello")
                        .setCallback(umShareListener)
                        .share();
            }
        });


        image_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开注册界面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {// 事件调用监听类

                    @Override
                    public void afterEvent(int event, int result, Object data) {//短信SDK操作回调
                        super.afterEvent(event, result, data);

                        //解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {// 如果状态为完成状态,表示注册成功
                            // 获取Data中的数据
                            HashMap<String, Object> dataMaps = (HashMap<String, Object>) data;
                            // 获取手机号所在国家信息
                            String country = (String) dataMaps.get("country");
                            // 获取收到验证码的手机号码
                            String phone = (String) dataMaps.get("phone");
                            // 提交信息到mob注册
                            //submitInfo(country, phone);
                        }

                    }
                });

                // 第三步：显示注册界面
                registerPage.show(getActivity());

            }
        });


        RadioButton_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.switchAppTheme(getActivity());
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.reload();
            }
        });
        //图片的点击事件
        image_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------------------------------------");
                /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
                 官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
                 第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(getActivity(), "all", mIUiListener);
            }
        });
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */

    class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(getActivity(), "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getActivity(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG, "登录成功" + response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(getActivity(), "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(getActivity(), "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void submitInfo(String country, String phone) {
        Random r = new Random();
        String uid = Math.abs(r.nextInt()) + "";
        String nickName = "设置个昵称";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);// 提交用户信息，在监听中返回
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            com.umeng.socialize.utils.Log.d("plat","platform"+platform);

            Toast.makeText(getActivity(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(getActivity(),platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                com.umeng.socialize.utils.Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(),platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
}

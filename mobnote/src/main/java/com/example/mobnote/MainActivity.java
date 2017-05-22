package com.example.mobnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butt_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SMSSDK.initSDK(this, "1ddc10f38ea8c", "3cb78ea2243a9645dfe87c73ce792857");
        butt_note = (Button) findViewById(R.id.butt_note);
        butt_note.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (butt_note == v) {
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
            registerPage.show(MainActivity.this);

        }
    }

    private void submitInfo(String country, String phone) {
        Random r = new Random();
        String uid = Math.abs(r.nextInt()) + "";
        String nickName = "设置个昵称";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);// 提交用户信息，在监听中返回
    }
}


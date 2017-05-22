package com.example.newsdemo.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newsdemo.R;

/**
 * name ：李飞宇
 * Date: 2017/5/17
 * desc:
 */

public class ContentEvery extends Activity {

    private WebView wfeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentevery);
        wfeb = (WebView) findViewById(R.id.web);
//        webView = (WebView) findViewById(view);
        wfeb.getSettings().setJavaScriptEnabled(true);
        wfeb.getSettings().setBuiltInZoomControls(true);
        wfeb.getSettings().setDefaultTextEncodingName("utf-8");
        ContentEvery contentEvery = this;

        wfeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wfeb.loadUrl(url);
                return true;
            }
        });
        Intent intent = getIntent();
        String aa = intent.getStringExtra("aa");

        wfeb.loadUrl(aa);

    }

}

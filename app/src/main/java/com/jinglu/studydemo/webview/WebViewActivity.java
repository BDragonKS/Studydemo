package com.jinglu.studydemo.webview;

import com.jinglu.studydemo.R;
import com.longruan.appframe.base.BaseActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.wv_content)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar(R.layout.activity_web_view, getString(R.string.web_view_title));
        initView();
    }

    private void initView() {
        WebSettings webSettings = mWebView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);

        // 禁用 file 协议；
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);

        mWebView.addJavascriptInterface(new JsToAndroid(this), "android");
        mWebView.loadUrl("file:///android_asset/jstoandroid.html");
    }
}

package com.jinglu.studydemo.webview;

import com.jinglu.studydemo.R;
import com.longruan.appframe.base.BaseActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.wv_content)
    WebView mWebView;
    WebViewClient mWebViewClient;
    WebChromeClient mWebChromeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar(R.layout.activity_web_view, getString(R.string.web_view_title));
        initView();
    }

    private void initView() {
        initWebViewClient();
        initWebChromeClient();
        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setWebChromeClient(mWebChromeClient);

        WebSettings webSettings = mWebView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);

        // 禁用 file 协议；
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);

        mWebView.addJavascriptInterface(new JsToAndroid(this), "android");
//        mWebView.loadUrl("file:///android_asset/jstoandroid.html");
        mWebView.loadUrl("http://39.107.203.10/");
    }

    /**
     * WebViewClient主要帮助WebView处理各种通知、请求事件
     */
    private void initWebViewClient() {
        mWebViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        };
    }

    /**
     * WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
     */
    private void initWebChromeClient() {

        mWebChromeClient = new WebChromeClient() {

            //弹窗
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                return super.onJsAlert(view, url, message, result);
                Toast.makeText(WebViewActivity.this, "testAlert", Toast.LENGTH_SHORT).show();
                return true;
            }

            //进度变化
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            //js加载之前
            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                return super.onJsBeforeUnload(view, url, message, result);
            }

            //js提示
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        };
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {

            mWebView.destroy();
        }
    }
}

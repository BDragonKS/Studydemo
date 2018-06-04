package com.jinglu.studydemo.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * <dl>  Class Description
 * <dd> 项目名称：Studydemo
 * <dd> 类名称：JsToAndroid
 * <dd> 类描述：js调用Android的方法
 * <dd> 创建时间：2018/6/4
 * <dd> 修改人：无
 * <dd> 修改时间：无
 * <dd> 修改备注：无
 * </dl>
 *
 * @author Jing Lu
 * @version 1.0
 */
public class JsToAndroid {

    Context mContext;

    public JsToAndroid(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void test() {
        Toast.makeText(mContext, "测试js调用Android方法", Toast.LENGTH_SHORT).show();
    }
}

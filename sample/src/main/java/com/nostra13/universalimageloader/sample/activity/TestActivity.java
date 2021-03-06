package com.nostra13.universalimageloader.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.nostra13.universalimageloader.sample.R;

/**
 * Created by caojun on 2018/1/9.
 */

public class TestActivity extends Activity {
    private WebView mWebView;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Log.e("myMessage",":");
        Log.e("myMessage",":p");

        mWebView =(WebView) findViewById(R.id.webview);

        WebSettings webSettings = mWebView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.loadUrl("file:///android_asset/javaScript.html");

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.e("myMessage",""+value);
                    }
                });
                // 通过Handler发送消息
//                mWebView.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        // 注意调用的JS方法名要对应上
//                        // 调用javascript的callJS()方法
//                        mWebView.loadUrl("javascript:callJS()");
//                    }
//                });

            }
        });

        // 由于设置了弹窗检验调用结果,所以需要支持js对话框
        // webview只是载体，内容的渲染需要使用webviewChromClient类去实现
        // 通过设置WebChromeClient对象处理JavaScript的对话框
        //设置响应js 的Alert()函数
//        mWebView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
//                AlertDialog.Builder b = new AlertDialog.Builder(TestActivity.this);
//                b.setTitle("Alert");
//                b.setMessage(message);
//                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        result.confirm();
//                    }
//                });
//                b.setCancelable(false);
//                b.create().show();
//                return true;
//            }
//
//        });

        Log.e("myMessage",":");

        mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {

            }
        });

    }
    private void test(){
  Log.e("2","");
    }

    private void newBranchs() {
        Log.e("new","fix bugs");
    }



    private void newFun() {
        Log.e("myMesssage","new 2.0");
    }
    }


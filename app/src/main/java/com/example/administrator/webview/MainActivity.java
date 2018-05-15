package com.example.administrator.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author gongkaiqiang
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 要显示信息的网址
     */
    private EditText editText;

    /**
     * 确定按钮
     */
    private Button button;

    /**
     * 展示
     */
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        webView = (WebView) findViewById(R.id.webview);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString().trim();
                openBrowser(url);
            }
        });
    }


    /**
     * 利用webView的loadUrl方法
     * @param url 显示的url
     */
    public void openBrowser(String url) {
        //滚动条在WebView内侧显示
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        //滚动条在WebView外侧显示
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //垂直不显示
        webView.setVerticalScrollBarEnabled(false);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.loadUrl(url);
    }
}

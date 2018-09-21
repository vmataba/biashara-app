package com.biashara.biasharaapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    private WebView webView;
    public static final String url = "http://akaunting.smprotz.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        getSupportActionBar().setTitle("MAFIA APP");

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 1000);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });



        webView.loadUrl(url);

    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        } else{
            super.onBackPressed();
        }

    }
}

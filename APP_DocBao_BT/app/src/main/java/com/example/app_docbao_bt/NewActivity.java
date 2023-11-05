package com.example.app_docbao_bt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        webview = (WebView) findViewById(R.id.webviewTinTuc);

        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTintuc");
        webview.loadUrl(link);
        webview.setWebChromeClient(new WebChromeClient());
    }
}
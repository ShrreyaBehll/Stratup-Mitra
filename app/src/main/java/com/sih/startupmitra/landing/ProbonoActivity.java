package com.sih.startupmitra.landing;
import android.webkit.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sih.startupmitra.R;

public class ProbonoActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probono);
        bindView();
    }

    private void bindView() {
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.startupindiahub.org.in/content/sih/en/reources/tools.html");
    }
}

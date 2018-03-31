package com.sih.startupmitra.landing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.sih.startupmitra.R;
import com.sih.startupmitra.api.ApiClientMaps;
import com.sih.startupmitra.api.GeneralAPI;
import com.sih.startupmitra.pojo.Maps;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WbRecycler extends AppCompatActivity {
    WebView webVsiew;
    Intent getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wb);
        getRetrofit();
    }
    private void getRetrofit() {
        getData = getIntent();
        webVsiew = findViewById(R.id.wb);
        webVsiew.loadUrl(getData.getStringExtra("url"));
    }

}

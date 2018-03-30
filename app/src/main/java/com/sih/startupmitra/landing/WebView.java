package com.sih.startupmitra.landing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.sih.startupmitra.R;
import com.sih.startupmitra.api.ApiClientMaps;
import com.sih.startupmitra.api.GeneralAPI;
import com.sih.startupmitra.pojo.Maps;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebView extends AppCompatActivity {
    WebView webVsiew;
    Intent getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getRetrofit();

    }

    private void getRetrofit() {
        getData = getIntent();
        GeneralAPI generalAPI = ApiClientMaps.getClient().create(GeneralAPI.class);
        Call<List<Maps>> call = generalAPI.getMaps();
        call.enqueue(new Callback<List<Maps>>() {
            @Override
            public void onResponse(Call<List<com.sih.startupmitra.pojo.Maps>> call, Response<List<Maps>> response) {
                Log.d("onRespinse", response.body().get(0).getName());
                for (int i = 0; i < response.body().size(); i++) {
                    if (getData.getStringExtra("title").equals(response.body().get(i).getOrganisation())) {
                        Toast.makeText(WebView.this, response.body().get(i).getOrganisation(), Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<com.sih.startupmitra.pojo.Maps>> call, Throwable t) {

            }
        });
    }

}

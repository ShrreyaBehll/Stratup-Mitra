package com.sih.startupmitra.Rec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sih.startupmitra.R;
import com.sih.startupmitra.api.ApiClient;
import com.sih.startupmitra.api.GeneralAPI;
import com.sih.startupmitra.pojo.MyPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedList extends AppCompatActivity {
    Intent getData;
    List<MyPojo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        intent();

    }

    private void intent() {
        list = new ArrayList<>();
        getData = getIntent();
        Log.d("getIntent", String.valueOf(getData.getIntExtra("name", 0)));
        getDataToRecycclerView(getData);

    }

    private void getDataToRecycclerView(Intent getData) {
        String sec = null, col = null;
        if (getData.getIntExtra("name", 0) == 1) {
            sec = "Education";
        } else if (getData.getIntExtra("name", 0) == 2) {
            sec = "Miscellaneous";
        } else if (getData.getIntExtra("name", 0) == 3) {
            sec = "Sector-agnostic";
        } else if (getData.getIntExtra("name", 0) == 4) {
            sec = "Travel & toursim";
        } else if (getData.getIntExtra("name", 0) == 5) {
            sec = "Energy";
        } else if (getData.getIntExtra("name", 0) == 6) {
            sec = "Healthcare & life sciences";
        }
        if (getData.getIntExtra("collateral", 0) == 1) {
            col = "yes";
        } else if (getData.getIntExtra("collateral", 0) == 1) {
            col = "no";
        }
        Log.d("onResponse",col);
        Log.d("onResponse",sec);

        GeneralAPI generalAPI = ApiClient.getClient().create(GeneralAPI.class);
        Call<MyPojo> call = generalAPI.getData(sec, Integer.parseInt(getData.getStringExtra("loan")), col);
        call.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                   try{
                   Log.d("onResponse",response.body().getScheme_name());
                   Log.d("onResponse",response.body().getCity_location());
                   Log.d("onResponse",response.body().getCollateral());  }catch (Exception e){
                       
                   }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {

            }
        });
    }
}

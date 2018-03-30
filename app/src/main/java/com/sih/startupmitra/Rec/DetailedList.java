package com.sih.startupmitra.Rec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.sih.startupmitra.R;
import com.sih.startupmitra.adapter.CustomBlogAdapter;
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
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        intent();

    }

    private void intent() {
        recycler_view = findViewById(R.id.recycler_view);
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
        } else if (getData.getIntExtra("collateral", 0) == 2) {
            col = "no";
        }
        Log.d("onResponse", String.valueOf(getData.getIntExtra("name", 0)));
        Log.d("onResponse", String.valueOf(getData.getIntExtra("collateral", 0)));
        Log.d("onResponse", String.valueOf(col));
        Log.d("onResponse", String.valueOf(sec));
        Log.d("onResponse", String.valueOf(getData.getStringExtra("loan")));

        GeneralAPI generalAPI = ApiClient.getClient().create(GeneralAPI.class);
        Call<List<MyPojo>> call = generalAPI.getData(sec, (getData.getStringExtra("loan")), col);
        call.enqueue(new Callback<List<MyPojo>>() {
            @Override
            public void onResponse(Call<List<MyPojo>> call, Response<List<MyPojo>> response) {

                assert response.body() != null;
//                Log.d("onResponse", response.body().toString());
                list = new ArrayList<>();
                List<MyPojo> schemeList = null;
                MyPojo myPojo;
                assert response.body() != null;
                schemeList = response.body();
                for (int i = 0; i < response.body().size(); i++) {
                    assert response.body() != null;
                     myPojo = new MyPojo();
                    Log.d("response", response.body().get(i).getSchemeName());
                    Log.d("response", response.body().get(i).getCityLocation());
                    myPojo.setSchemeName(schemeList.get(i).getSchemeName());
                    myPojo.setHeadedBy(schemeList.get(i).getHeadedBy());
                    myPojo.setSourceOfGrants(schemeList.get(i).getSourceOfGrants());
                    myPojo.setSerialNumber(schemeList.get(i).getSerialNumber());
                    myPojo.setSector(schemeList.get(i).getSector());
                    myPojo.setRegLink(schemeList.get(i).getRegLink());
                    myPojo.setLoanRange(schemeList.get(i).getLoanRange());
                    list.add(myPojo);

                }
                CustomBlogAdapter customBlogAdapter = new CustomBlogAdapter(DetailedList.this,list);
                RecyclerView.LayoutManager recycelrviewAdapterManager = new LinearLayoutManager(DetailedList.this);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler_view.getContext(), DividerItemDecoration.VERTICAL);
                recycler_view.addItemDecoration(dividerItemDecoration);
                recycler_view.setLayoutManager(recycelrviewAdapterManager);
                recycler_view.setAdapter(customBlogAdapter);


            }

            @Override
            public void onFailure(Call<List<MyPojo>> call, Throwable t) {
                Log.d("onResponse", t.getLocalizedMessage());

            }
        });
    }
}

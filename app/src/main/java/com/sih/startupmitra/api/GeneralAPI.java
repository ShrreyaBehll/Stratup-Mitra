package com.sih.startupmitra.api;


import com.sih.startupmitra.pojo.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by himanshusingh on 30/06/17.
 */

public interface GeneralAPI {

    @GET("/api.php?")
    Call<MyPojo> getData(
            @Query("sector") String sector,
            @Query("loan_range") int loan_range,
            @Query("collateral") String collateral);

}

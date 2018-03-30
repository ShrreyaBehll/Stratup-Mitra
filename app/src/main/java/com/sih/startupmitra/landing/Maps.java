package com.sih.startupmitra.landing;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sih.startupmitra.R;
import com.sih.startupmitra.api.ApiClient;
import com.sih.startupmitra.api.ApiClientMaps;
import com.sih.startupmitra.api.GeneralAPI;
import com.sih.startupmitra.pojo.MyPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Maps extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        getRetrofit(googleMap);
        LatLng mumbai = new LatLng(19.07283, 72.88261);
//
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mumbai,10));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null);
        googleMap.setOnMarkerClickListener(marker -> {
            Intent intent = new Intent(this,Wb.class);
            intent.putExtra("title",marker.getTitle());
            startActivity(intent);
            return false;
        });

    }

    private void getRetrofit(GoogleMap googleMap) {
        GeneralAPI generalAPI = ApiClientMaps.getClient().create(GeneralAPI.class);
        Call<List<com.sih.startupmitra.pojo.Maps>> call = generalAPI.getMaps();
        call.enqueue(new Callback<List<com.sih.startupmitra.pojo.Maps>>() {
            @Override
            public void onResponse(Call<List<com.sih.startupmitra.pojo.Maps>> call, Response<List<com.sih.startupmitra.pojo.Maps>> response) {
                Log.d("onRespinse", response.body().get(0).getName());
                for (int i = 0; i < response.body().size(); i++) {
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(response.body().get(i).getLatitude(), response.body().get(i).getLongitude())).title(response.body().get(i).getOrganisation()));
                }
            }

            @Override
            public void onFailure(Call<List<com.sih.startupmitra.pojo.Maps>> call, Throwable t) {

            }
        });
    }

}
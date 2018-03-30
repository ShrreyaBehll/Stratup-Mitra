package com.sih.startupmitra.landing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.sih.startupmitra.R;
import com.sih.startupmitra.Rec.Recomend;

public class Dashboard extends AppCompatActivity {
    CardView recommend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);
        bindView();
    }

    private void bindView() {
        recommend = findViewById(R.id.recommend);
        recommend.setOnClickListener(view -> startActivity(new Intent(this, Recomend.class)));
    }
}

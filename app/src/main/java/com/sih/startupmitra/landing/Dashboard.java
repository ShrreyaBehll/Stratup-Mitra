package com.sih.startupmitra.landing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.sih.startupmitra.R;
import com.sih.startupmitra.Rec.Recomend;
import com.sih.startupmitra.SetLanguage;
import com.sih.startupmitra.util.SharedPreference;

public class Dashboard extends AppCompatActivity {
    CardView recommend;

    FloatingActionMenu menu;
    FloatingActionButton english_item;
    FloatingActionButton hindi_item;
    FloatingActionButton marathi_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);
        bindView();
    }

    private void bindView() {
        recommend = findViewById(R.id.recommend);
        recommend.setOnClickListener(view -> startActivity(new Intent(this, Recomend.class)));


        menu= findViewById(R.id.language_menu);
        english_item = menu.findViewById(R.id.english_item);
        hindi_item= menu.findViewById(R.id.hindi_item);
        marathi_item=menu.findViewById(R.id.marathi_item);

        english_item.setOnClickListener(view -> {
            SharedPreference.write("Language","eu");
            SharedPreference.write("showsplash",false);
            SharedPreference.setFirstTimeLaunch(false);
            startActivity(new Intent(Dashboard.this,SetLanguage.class));
        });

        hindi_item.setOnClickListener(view -> {
            SharedPreference.setFirstTimeLaunch(false);
            SharedPreference.write("showsplash",false);
            SharedPreference.write("Language","hi");
            startActivity(new Intent(Dashboard.this,SetLanguage.class));
        });


        marathi_item.setOnClickListener(view -> {
            SharedPreference.setFirstTimeLaunch(false);
            SharedPreference.write("showsplash",false);
            SharedPreference.write("Language","mr");
            startActivity(new Intent(Dashboard.this,SetLanguage.class));
        });
    }
}

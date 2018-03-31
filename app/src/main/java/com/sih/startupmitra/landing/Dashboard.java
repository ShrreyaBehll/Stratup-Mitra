package com.sih.startupmitra.landing;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.model.Dash;
import com.klinker.android.peekview.PeekViewActivity;
import com.klinker.android.peekview.builder.Peek;
import com.klinker.android.peekview.builder.PeekViewOptions;
import com.klinker.android.peekview.callback.OnPeek;
import com.klinker.android.peekview.callback.SimpleOnPeek;
import com.sih.startupmitra.R;
import com.sih.startupmitra.Rec.Recomend;
import com.sih.startupmitra.SetLanguage;
import com.sih.startupmitra.individual_register.StartupRegisterActivity;
import com.sih.startupmitra.util.SharedPreference;

public class Dashboard extends PeekViewActivity {
    CardView recommend;

    LinearLayout register_ur_startup;

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

    private void loadPeek() {
        AlertDialog.Builder ImageDialog = new AlertDialog.Builder(Dashboard.this);

        ImageView showImage = new ImageView(Dashboard.this);
        showImage.setImageDrawable(getResources().getDrawable(R.drawable.qrcode));
        ImageDialog.setView(showImage);

        ImageDialog.setNegativeButton("ok", (arg0, arg1) -> {
        });
        ImageDialog.show();

//        dialog.setOnShowListener(d -> {
//            ImageView image = dialogLayout.findViewById(R.id.image);
//            Bitmap icon = BitmapFactory.decodeResource(getResources(),
//                    R.drawable.qrcode);
//            float imageWidthInPX = (float) image.getWidth();
//
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(imageWidthInPX),
//                    Math.round(imageWidthInPX * (float) icon.getHeight() / (float) icon.getWidth()));
//            image.setLayoutParams(layoutParams);
//
//            image.setImageBitmap(icon);
//        });
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

        register_ur_startup=findViewById(R.id.register_your_startup);
        register_ur_startup.setOnClickListener(view -> {
            startActivity(new Intent(Dashboard.this, StartupRegisterActivity.class));
        });

        findViewById(R.id.qrCode_img).setOnClickListener(view -> loadPeek());
    }
}

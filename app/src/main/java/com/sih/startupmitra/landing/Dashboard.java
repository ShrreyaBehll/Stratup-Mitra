package com.sih.startupmitra.landing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sih.startupmitra.R;
import com.sih.startupmitra.Rec.Recomend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Dashboard extends AppCompatActivity {
    CardView recommend, maps, register, card;
    TextView share;
    File imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);
        bindView();
    }

    private void bindView() {
        recommend = findViewById(R.id.recommend);
        card = findViewById(R.id.card);
        share = findViewById(R.id.share);
        maps = findViewById(R.id.maps);
        register = findViewById(R.id.register);
        recommend.setOnClickListener(view -> startActivity(new Intent(this, Recomend.class)));
        register.setOnClickListener(view -> startActivity(new Intent(this, ProbonoActivity.class)));
        maps.setOnClickListener(view -> startActivity(new Intent(this, Maps.class)));
        share.setOnClickListener(view -> {
            Toast.makeText(Dashboard.this,"clicked",Toast.LENGTH_SHORT).show();
            Bitmap bitmap = takeScreenshot();
            saveBitmap(bitmap);
            shareIt();

        });

    }
    public Bitmap takeScreenshot() {
        CardView cardView = findViewById(R.id.card);
        cardView.setDrawingCacheEnabled(true);
        return cardView.getDrawingCache();
    }
    public void saveBitmap(Bitmap bitmap) {
        imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
    private void shareIt() {
        try {
            Uri uri = Uri.fromFile(imagePath);
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("image/*");
            String shareBody = "Check the Real-time rate of Crypto Currencies on https://play.google.com/store/apps/details?id=xyz.himanshusingh.cryptokoin";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Tweecher score");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);

            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }catch (Exception e){}
    }

   
}

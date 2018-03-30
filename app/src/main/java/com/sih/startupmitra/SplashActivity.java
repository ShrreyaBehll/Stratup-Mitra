package com.sih.startupmitra;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sih.startupmitra.individual_register.RegisterAdhar;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        newSplash();
    }

    private void newSplash() {
        new Handler().postDelayed(() -> {
            //new activity after splash screen
            startActivity(new Intent(this, RegisterAdhar.class));
        }, SPLASH_TIME_OUT);
    }
}

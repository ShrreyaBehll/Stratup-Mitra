package com.sih.startupmitra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.sih.startupmitra.landing.Dashboard;
import com.sih.startupmitra.util.CustomFontTextView;
import com.sih.startupmitra.util.SharedPreference;

import java.util.Locale;

public class SetLanguage extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private Locale myLocale;
    private RadioGroup mLanguage;
    private TextView pick;
    private RadioButton mEng, mHindi;
    private Button Continue;

    String langPref = "Language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_language);
        SharedPreference.init(SetLanguage.this);
        loadLocale();
        if (!SharedPreference.isFirstTimeLaunch()) {
            if(!SharedPreference.read("showsplash",true)){
                launchDashboard();
            }else{
                launchHomeScreen();
            }

            finish();
        } else {
            Continue.setOnClickListener(v -> {
                SharedPreference.setFirstTimeLaunch(false);
                startActivity(new Intent(SetLanguage.this, Dashboard.class));
                finish();
            });
        }
    }

    private void launchDashboard() {
        startActivity(new Intent(SetLanguage.this, Dashboard.class));
    }

    private void launchHomeScreen() {
        startActivity(new Intent(SetLanguage.this, SplashActivity.class));
    }

    private void loadLocale() {
        String langPref = "Language";
        if(SharedPreference.isFirstTimeLaunch()){
            SharedPreference.write(langPref,"en");
        }
        String language = SharedPreference.read(langPref, null);
        changeLang(language);
        addListenerOnButton();
        mLanguage.setOnCheckedChangeListener(this);
        }



    private void addListenerOnButton() {
        pick = findViewById(R.id.pick);
        mLanguage = findViewById(R.id.language);
        mEng = findViewById(R.id.eng);
        mHindi = findViewById(R.id.hindi);
        Continue = findViewById(R.id.continuee);
    }

    public void saveLocale(String lang) {

        SharedPreference.write(langPref,lang);

    }

    public void changeLang(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreference.write(langPref,lang);
    }

    private void updateTextsHindi() {
        Continue.setText(getResources().getString(R.string.string));
        pick.setText(getResources().getString(R.string.pickhindi));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        String lang = "en";
        switch (checkedId) {
            case R.id.eng:
                lang = "en";
                updateTextsEnglish();
                break;
            case R.id.hindi:
                lang = "hi";
                updateTextsHindi();
                break;
            case R.id.marathi:
                lang = "mr";
                updateTextMarathi();
            default:
                break;
        }
        changeLang(lang);

    }

    private void updateTextMarathi() {
        Continue.setText(getResources().getString(R.string.string));
        pick.setText(getResources().getString(R.string.pickhindi));
    }

    private void updateTextsEnglish() {
        Continue.setText("Continue");
        pick.setText("Pick Your Language");
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (myLocale != null) {
            newConfig.locale = myLocale;
            Locale.setDefault(myLocale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}

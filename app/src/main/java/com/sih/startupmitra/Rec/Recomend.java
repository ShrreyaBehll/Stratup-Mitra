package com.sih.startupmitra.Rec;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.sih.startupmitra.R;

import org.angmarch.views.NiceSpinner;

import java.text.DecimalFormat;
import java.text.Format;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Recomend extends AppCompatActivity {
    List<String> sector;
    List<String> colateral;
    SeekBar seekbar;
    EditText loan;
    Button setting;
    NiceSpinner spinnerSector;
    NiceSpinner ColateralSpinner;
    private String loan_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        bindView();
        setData();
    }

    private void bindView() {
        spinnerSector = findViewById(R.id.spinner_relation);
        seekbar = findViewById(R.id.seekbar);
        loan = findViewById(R.id.text_view_spinner);
        setting = findViewById(R.id.setting);
        ColateralSpinner = findViewById(R.id.radio);
        sector = new ArrayList<>();
        colateral = new ArrayList<>();
        sector.add(getString(R.string.sector));
        sector.add(getString(R.string.education));
        sector.add(getString(R.string.it_services));
        sector.add(getString(R.string.miscellaneous));
        sector.add(getString(R.string.sec_agnostic));
        sector.add(getString(R.string.travel));
        sector.add(getString(R.string.energy));
        sector.add(getString(R.string.health));
        spinnerSector.attachDataSource(sector);
        colateral.add(getString(R.string.option));
        colateral.add(getString(R.string.yes));
        colateral.add(getString(R.string.no));
        ColateralSpinner.attachDataSource(colateral);
    }

    private void setData() {

        seekbar.setMax(5000000);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("Seekbar : ", String.valueOf(i));
                loan_amount= String.valueOf(i);
                loan.setText("₹ "+String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        setting.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailedList.class);
            intent.putExtra("name",spinnerSector.getSelectedIndex());
            intent.putExtra("collateral",ColateralSpinner.getSelectedIndex());
            intent.putExtra("loan",loan.getText().toString());
            startActivity(intent);
        });

    }
}

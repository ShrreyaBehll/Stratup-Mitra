package com.sih.startupmitra.Rec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.sih.startupmitra.R;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

public class Recomend extends AppCompatActivity {
    List<String> sector;
    List<String> colateral;
    SeekBar seekbar;
    EditText loan;
    Button setting;
    NiceSpinner spinnerSector;
    NiceSpinner ColateralSpinner;

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
        sector.add("Sector");
        sector.add("Education");
        sector.add("IT Services");
        sector.add("Miscellaneous");
        sector.add("Sector-agnostic");
        sector.add("Travel & tourism");
        sector.add("Energy");
        sector.add("Healthcare & life sciences");
        spinnerSector.attachDataSource(sector);
        colateral.add("---Option--");
        colateral.add("Yes");
        colateral.add("No");
        ColateralSpinner.attachDataSource(colateral);
    }

    private void setData() {
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("Seekbar : ", String.valueOf(i));
                loan.setText(String.valueOf(i));

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

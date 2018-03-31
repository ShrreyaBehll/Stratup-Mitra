package com.sih.startupmitra.individual_register;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.heinrichreimersoftware.singleinputform.SingleInputFormActivity;
import com.heinrichreimersoftware.singleinputform.steps.DateStep;
import com.heinrichreimersoftware.singleinputform.steps.OptionStep;
import com.heinrichreimersoftware.singleinputform.steps.Step;
import com.heinrichreimersoftware.singleinputform.steps.TextStep;
import com.sih.startupmitra.R;

import java.util.ArrayList;
import java.util.List;

public class StartupRegisterActivity extends SingleInputFormActivity {

    private static final String DATA_KEY_STARTUP_NAME = "startup";
    private static final String DATA_KEY_INDUSTRY = "industry";
    private static final String DATA_KEY_SECTOR = "sector";
    private static final String DATA_KEY_CATEGORY = "category";
    private static final String DATA_KEY_STARTUP_REG_NO = "reg_no";
    private static final String DATA_KEY_DATE_REG = "date_reg";
    private static final String DATA_PAN_NO = "pan_no";
    private ArrayList steps;


    @Override
    protected List<Step> onCreateSteps() {
        steps = new ArrayList<>();


        setInputGravity(Gravity.CENTER);

        steps.add(new TextStep.Builder(this, DATA_KEY_STARTUP_NAME)
                .titleResId(R.string.name_of_startup)

                .detailsResId(R.string.enter_full_name)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .build());

        steps.add(new OptionStep.Builder(this, DATA_KEY_INDUSTRY)
                .titleResId(R.string.choose_industry)
                .options(getResources().getStringArray(R.array.industry_items))
                .detailsResId(R.string.choose_resp_industry)
                .build());

        steps.add(new OptionStep.Builder(this, DATA_KEY_CATEGORY)
                .titleResId(R.string.choose_category)
                .options(getResources().getStringArray(R.array.categories))
                .detailsResId(R.string.choose_resp_category)
                .build());
        steps.add(new TextStep.Builder(this, DATA_KEY_STARTUP_REG_NO)
                .titleResId(R.string.reg_no)
                .errorResId(R.string.not_valid)
                .detailsResId(R.string.enter_startup_reg)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .build());
        steps.add(new DateStep.Builder(this,DATA_KEY_DATE_REG)
                .titleResId(R.string.reg_date)
                .detailsResId(R.string.enter_reg_date)
                .inputType(InputType.TYPE_DATETIME_VARIATION_DATE)
                .build());

        steps.add(new TextStep.Builder(this, DATA_PAN_NO)
                .titleResId(R.string.pan_no)
                .errorResId(R.string.not_valid)
                .detailsResId(R.string.enter_pan)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .build());

        return steps;
    }


    @Override
    protected Step getCurrentStep() {

        return super.getCurrentStep();
    }

    @Override
    protected void nextStep() {

//        if (getCurrentStep().getTitle(this).equals(getResources().getString(R.string.choose_industry))) {
//            String data = ((EditText) getCurrentStep().getView()).getText().toString();
//
//            Step sectorStep;
//            switch (data.toLowerCase()) {
//                case "agriculture":
//                    sectorStep = new OptionStep.Builder(this, DATA_KEY_SECTOR)
//                            .titleResId(R.string.choose_sector)
//                            .options(getResources().getStringArray(R.array.agriculture))
//                            .detailsResId(R.string.choose_resp_sector)
//                            .build();
//                    break;
//
//                case "it services":
//                    sectorStep = new OptionStep.Builder(this, DATA_KEY_SECTOR)
//                            .titleResId(R.string.choose_sector)
//                            .options(getResources().getStringArray(R.array.it_services))
//                            .detailsResId(R.string.choose_resp_sector)
//                            .build();
//                    break;
//                case "healthcare and lifesciences":
//                    sectorStep = new OptionStep.Builder(this, DATA_KEY_SECTOR)
//                            .titleResId(R.string.choose_sector)
//                            .options(getResources().getStringArray(R.array.health_list))
//                            .detailsResId(R.string.choose_resp_sector)
//                            .build();
//                    break;
//                default:
//                    sectorStep = new OptionStep.Builder(this, DATA_KEY_SECTOR)
//                            .titleResId(R.string.choose_sector)
//                            .options(getResources().getStringArray(R.array.it_services))
//                            .detailsResId(R.string.choose_resp_sector)
//                            .build();
//
//            }
//
//            steps.add(2, sectorStep);
//        }
        super.nextStep();

    }



    @Override
    protected void onFormFinished(Bundle data) {
//        Toast.makeText(this, "Form finished: " + TextStep.text(data, DATA_KEY_EMAIL)
//                , Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "data: " + data.toString());


        startActivity(new Intent(this,RegisterAdhar.class));
        finish();
    }
}

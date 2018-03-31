package com.sih.startupmitra.individual_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;

import com.heinrichreimersoftware.singleinputform.SingleInputFormActivity;
import com.heinrichreimersoftware.singleinputform.steps.Step;
import com.heinrichreimersoftware.singleinputform.steps.TextStep;
import com.sih.startupmitra.R;
import com.sih.startupmitra.landing.Dashboard;
import com.sih.startupmitra.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

public class IndividualActivity extends SingleInputFormActivity{


    private static final String DATA_KEY_STARTUP_NAME = "name";
    private static final String DATA_KEY_EMAIL = "email";
    private static final String DATA_KEY_NUMBER = "number";
    private static final String DATA_KEY_PASSWORD = "password";
    private ArrayList steps;

    @Override
    protected List<Step> onCreateSteps() {
        steps = new ArrayList<>();


        setInputGravity(Gravity.CENTER);

        steps.add(new TextStep.Builder(this, DATA_KEY_STARTUP_NAME)
                .titleResId(R.string.name)
                .detailsResId(R.string.name_details)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .build());

        steps.add(new TextStep.Builder(this, DATA_KEY_EMAIL)
                .titleResId(R.string.email)
                .detailsResId(R.string.email_details_text)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .build());
        steps.add(new TextStep.Builder(this,DATA_KEY_NUMBER)
                .titleResId(R.string.contact)
                .errorResId(R.string.not_valid)
                .detailsResId(R.string.mobile_detail_text)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .build());
        steps.add(new TextStep.Builder(this, DATA_KEY_PASSWORD)
                .titleResId(R.string.password)
                .errorResId(R.string.password_error)
                .detailsResId(R.string.password_details)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .validator(new TextStep.Validator() {
                    @Override
                    public boolean validate(String input) {
                        return input.length() >= 5;
                    }
                })
                .build());

        return steps;
    }

    @Override
    protected void onFormFinished(Bundle bundle) {

        startActivity(new Intent(this,RegisterAdhar.class));
        finish();
    }
}

package com.sih.startupmitra.individual_register;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.sih.startupmitra.R;
        import com.sih.startupmitra.landing.Dashboard;

public class RegisterAdhar extends AppCompatActivity {
    EditText aadhaar_number_textview;
    Button aadhaar_proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhar_card);
        bindView();
    }

    private void bindView() {
        aadhaar_number_textview = findViewById(R.id.aadhaar_number_textview);
        aadhaar_proceed = findViewById(R.id.aadhaar_proceed);
        aadhaar_proceed.setOnClickListener(view -> {
           startActivity(new Intent(this, Dashboard.class));
        });
     }




}

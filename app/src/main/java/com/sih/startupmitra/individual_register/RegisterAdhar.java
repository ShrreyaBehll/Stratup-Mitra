package com.sih.startupmitra.individual_register;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.widget.EditText;

        import com.sih.startupmitra.R;

public class RegisterAdhar extends AppCompatActivity {
    EditText aadhaar_number_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhar_card);
        bindView();
    }

    private void bindView() {
        aadhaar_number_textview = findViewById(R.id.aadhaar_number_textview);
     }




}

package com.xdm.pureb;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextWatcher;
import android.widget.EditText;
import android.text.Editable;


public class OtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);

        EditText otpEditText1 = findViewById(R.id.otpEditText1);
        EditText otpEditText2 = findViewById(R.id.otpEditText2);
        EditText otpEditText3 = findViewById(R.id.otpEditText3);
        EditText otpEditText4 = findViewById(R.id.otpEditText4);
        EditText otpEditText5 = findViewById(R.id.otpEditText5);
        EditText otpEditText6 = findViewById(R.id.otpEditText6);

        setUpOtpEditText(otpEditText1, otpEditText2);
        setUpOtpEditText(otpEditText2, otpEditText3);
        setUpOtpEditText(otpEditText3, otpEditText4);
        setUpOtpEditText(otpEditText4, otpEditText5);
        setUpOtpEditText(otpEditText5, otpEditText6);
        setUpOtpEditText(otpEditText6, null);


        findViewById(R.id.loginButton).setOnClickListener(v -> {
            Intent intent = new Intent(OtpActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setUpOtpEditText(final EditText currentEditText, final EditText nextEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    if (nextEditText != null) {
                        nextEditText.requestFocus();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
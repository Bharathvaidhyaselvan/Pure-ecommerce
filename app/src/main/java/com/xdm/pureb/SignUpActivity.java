package com.xdm.pureb;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private EditText dobEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize EditText fields
        dobEditText = findViewById(R.id.dobEditText);
        emailEditText = findViewById(R.id.emailEditText);

        // Set up DatePickerDialog for Date of Birth EditText
        dobEditText.setOnClickListener(v -> showDatePicker());

        // Set up sign up button click listener
        Button signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(v -> validateAndSubmit());
    }

    // Method to show DatePickerDialog
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and show DatePickerDialog
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) ->
                        dobEditText.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1),
                year, month, day);
        datePickerDialog.show();
    }

    // Method to validate email and proceed with signup
    private void validateAndSubmit() {
        String email = emailEditText.getText().toString().trim();

        if (!isValidEmail(email)) {
            emailEditText.setError("Invalid email");
            emailEditText.requestFocus();
        } else {
            // Proceed with the signup process
            Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to validate email using Patterns.EMAIL_ADDRESS
    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}

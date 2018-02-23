package com.example.sndpkiran.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class SignUpActivity extends AppCompatActivity {
    protected Button signUp;
    protected EditText fullName;
    protected EditText email;
    protected EditText password;
    protected EditText confirmPassword;

    protected String fullNameText;
    protected String emailText;
    protected String passwordText;
    protected String confirmPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName = findViewById(R.id.inputFullName);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        confirmPassword = findViewById(R.id.inputConfirmPassword);
        signUp = findViewById(R.id.signUpButton);

        signUp.setOnClickListener(signUpListener);
    }

    public View.OnClickListener signUpListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean valid = true;

            fullNameText = fullName.getText().toString();
            emailText = email.getText().toString();
            passwordText = password.getText().toString();
            confirmPasswordText = confirmPassword.getText().toString();

            // check if fields are not empty
            if (fullNameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty() || confirmPasswordText.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please check if you have filled every field", Toast.LENGTH_SHORT).show();
                valid = false;
                return;
            }

            // check if email is valid
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(SignUpActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                valid = false;
                return;
            }

            // Check if passwords match
            if (!passwordText.equals(confirmPasswordText)) {
                Toast.makeText(SignUpActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                valid = false;
                return;
            }

            //TODO: Implement sign up
            if(valid) {
                Intent homeIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                homeIntent.putExtra("fullName", fullNameText);
                homeIntent.putExtra("email", emailText);
                startActivity(homeIntent);
            }

        }
    };
}

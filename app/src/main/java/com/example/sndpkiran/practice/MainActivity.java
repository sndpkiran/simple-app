package com.example.sndpkiran.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    protected EditText emailText;
    protected EditText passwordText;
    protected Button loginButton;

    protected String email;
    protected String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = findViewById(R.id.inputEmail);
        passwordText = findViewById(R.id.inputPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(loginListener);
    }

    public View.OnClickListener loginListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean valid = true;
            email = emailText.getText().toString();
            password = passwordText.getText().toString();

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailText.setError("Please Enter a valid email address");
                valid = false;
            }

            //TODO:  Also check if the password matches
            if (password.isEmpty()) {
                passwordText.setError("Incorrect password. Please try again.");
                valid  =  false;
            }

            if (valid) {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivityForResult(homeIntent, 1);
            }
        }
    };
}

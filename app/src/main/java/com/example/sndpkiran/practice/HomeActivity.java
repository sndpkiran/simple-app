package com.example.sndpkiran.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class HomeActivity extends AppCompatActivity {

    protected TextView welcomeText;

    protected String fullName;
    protected String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeText = findViewById(R.id.welcomeText);

        Intent i = getIntent();
        try {
            fullName = i.getStringExtra("fullName");
            email = i.getStringExtra("email");
        } catch (NullPointerException e) {
            Toast.makeText(this, "Oops! Something went wrong.", Toast.LENGTH_SHORT).show();
            finish();
        }
        welcomeText.setText("Hi! " + fullName + ". Your email: " + email);
    }
}

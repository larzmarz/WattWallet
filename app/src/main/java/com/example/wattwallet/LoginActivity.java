package com.example.wattwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout etUsername = findViewById(R.id.etUsername);
        TextInputLayout etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);
        Button btSignup = findViewById(R.id.btSignup);
        // activate login button
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sets the users inputs as username and password values that will be passed to login method
                String username = etUsername.getEditText().getText().toString();
                String password = etPassword.getEditText().getText().toString();
                loginUser(username, password);
            }
        });
        // if user clicks signup button
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSignupActivity();
            }
        });
    }

    private void goSignupActivity() {

    }

    private void loginUser(String username, String password) {
    }
}
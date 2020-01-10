package com.anish.hamrobazarapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anish.hamrobazarapi.bll.Loginbll;
import com.anish.hamrobazarapi.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUsername, etPassword;
    private TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        int i = R.drawable.bike;
//        Toast.makeText(this, i+"", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvSignup = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(); }
        });

    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Loginbll loginBLL = new Loginbll();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();
        }
    }


}




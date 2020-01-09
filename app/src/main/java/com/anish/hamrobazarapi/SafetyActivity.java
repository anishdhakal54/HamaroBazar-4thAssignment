package com.anish.hamrobazarapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class SafetyActivity extends AppCompatActivity {
    private Text txtSafety;
    private Button btnSafety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        btnSafety = findViewById(R.id.btnSafety);

        btnSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SafetyActivity.super.onBackPressed();
            }
        });
    }
}

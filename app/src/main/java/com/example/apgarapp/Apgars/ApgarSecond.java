package com.example.apgarapp.Apgars;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apgarapp.R;


public class ApgarSecond extends AppCompatActivity{
    private Button BpmMoreButton;
    private Button BmpLessButton;
    private Button AbsenPulsetButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Find the buttons in the layout for PULSE
        BpmMoreButton = findViewById(R.id.BpmMoreButton);
        BmpLessButton = findViewById(R.id.BpmLessButton);
        AbsenPulsetButton = findViewById(R.id.AbsenPulsetButton);

        BpmMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Active button click
            }
        });

        BmpLessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Some button click
            }
        });

        AbsenPulsetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Limp button click
            }
        });
    }
}

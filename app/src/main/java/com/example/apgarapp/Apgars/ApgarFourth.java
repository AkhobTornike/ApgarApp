package com.example.apgarapp.Apgars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apgarapp.R;

public class ApgarFourth extends AppCompatActivity{
    private Button allPinkButton;
    private Button PinkButton;
    private Button blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Find the buttons in the layout for ACTIVE
        allPinkButton = findViewById(R.id.allPinkButton);
        PinkButton = findViewById(R.id.PinkButton);
        blueButton = findViewById(R.id.blueButton);

        // Set click listeners for the buttons
        allPinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Active button click
            }
        });

        PinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Some button click
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Limp button click
            }
        });
    }
}

package com.example.apgarapp.Apgars;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apgarapp.R;

public class ApgarThird extends AppCompatActivity{
    private Button SneezeButton;
    private Button GrimaceButton;
    private Button NoneButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Find the buttons in the layout for ACTIVE
        SneezeButton = findViewById(R.id.SneezeButton);
        GrimaceButton = findViewById(R.id.GrimaceButton);
        NoneButton = findViewById(R.id.NoneButton);

        // Set click listeners for the buttons
        SneezeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Active button click
            }
        });

        GrimaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Some button click
            }
        });

        NoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Limp button click
            }
        });
    }
}

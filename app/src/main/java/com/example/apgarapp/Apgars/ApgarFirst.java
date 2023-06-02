package com.example.apgarapp.Apgars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apgarapp.R;

public class ApgarFirst extends AppCompatActivity{
    private Button ActiveButton;
    private Button SomeButton;
    private Button LimpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Find the buttons in the layout for ACTIVE
        ActiveButton = findViewById(R.id.ActiveButton);
        SomeButton = findViewById(R.id.SomeButton);
        LimpButton = findViewById(R.id.LimpButton);

        // Set click listeners for the buttons
        ActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Active button click
            }
        });

        SomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Some button click
            }
        });

        LimpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Limp button click
            }
        });
    }
}

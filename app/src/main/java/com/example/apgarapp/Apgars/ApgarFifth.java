package com.example.apgarapp.Apgars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apgarapp.R;

public class ApgarFifth extends AppCompatActivity{
    private Button GoodCryingButton;
    private Button IrregularSlowButton;
    private Button AbsentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Find the buttons in the layout for ACTIVE
        GoodCryingButton = findViewById(R.id.GoodCryingButton);
        IrregularSlowButton = findViewById(R.id.IrregularSlowButton);
        AbsentButton = findViewById(R.id.AbsentButton);

        // Set click listeners for the buttons
        GoodCryingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Active button click
            }
        });

        IrregularSlowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Some button click
            }
        });

        AbsentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform actions for Limp button click
            }
        });
    }
}

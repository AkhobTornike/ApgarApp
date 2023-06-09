package com.example.apgarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();

        String heartRate = bundle.getString("heartRate");
        String respiratory = bundle.getString("respiratory");
        String muscleTone = bundle.getString("muscleTone");
        String reflex = bundle.getString("reflex");
        String color = bundle.getString("color");

        TextView heartRateTextView = findViewById(R.id.heartRateTextView);
        heartRateTextView.setText(heartRate);

        TextView respiratoryTextView = findViewById(R.id.respiratoryTextView);
        respiratoryTextView.setText(respiratory);

        TextView muscleToneTextView = findViewById(R.id.muscleToneTextView);
        muscleToneTextView.setText(muscleTone);

        TextView reflexTextView = findViewById(R.id.reflexTextView);
        reflexTextView.setText(reflex);

        TextView colorTextView = findViewById(R.id.colorTextView);
        colorTextView.setText(color);
    }
}
package com.example.apgarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Apgar1 extends AppCompatActivity {

    private TextView timerTextView; // Declare the timer TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar1);

        // Retrieve the baby name from the intent extras
        String babyName = getIntent().getStringExtra("name");

        // Find the TextView in the layout
        TextView babyNameTextView = findViewById(R.id.babyNameTextView);
        // Find the timer TextView
        timerTextView = findViewById(R.id.timerTextView);

        // Set the baby name in the TextView
        babyNameTextView.setText(babyName);

        startTimer(); // Start the timer
    }

    private void startTimer() {
        // Define the total duration of the time (in milliseconds)
        long totalDuration = 10 * 60 * 1000; // 10 minutes

        // Define the interval for the timer tick in (in milliseconds)
        long reminder1Interval = 7 * 60 * 1000; // 7 minutes
        long reminder2Interval = 3 * 60 * 1000; // 3 minutes

        // Create a new CountDownTimer
        CountDownTimer timer = new CountDownTimer(totalDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Calculate the minutes and seconds remaining
                long seconds = millisUntilFinished/1000;
                long minutes = seconds / 60;
                seconds %= 60;

                // Format the minutes and seconds as a string
                String timeRemaining = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                timerTextView.setText(timeRemaining);

                if(millisUntilFinished <= reminder1Interval) {
                    showReminder("Second Apgar score");
                } else if (millisUntilFinished <= reminder2Interval) {
                    showReminder("third Apgar score");
                } else {
                    showReminder("first Apgar score");
                }
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Timer Finished!");
            }
        };

        timer.start();
    }

    private void showReminder(String reminderMessage) {
        Toast.makeText(Apgar1.this, reminderMessage, Toast.LENGTH_SHORT).show();
    }
}
package com.example.apgarapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ApgarScore extends AppCompatActivity {
    // Declare the timer TextView
    private TextView timerTextView;

    private RadioButton Less100Radio;
    private RadioButton More100Radio;
    private RadioButton WeakBreathing;
    private RadioButton StrongBreathing;
    private RadioButton Some;
    private RadioButton Active;
    private RadioButton Grimace;
    private RadioButton ActiveWithdrawal;
    private RadioButton Blue;
    private RadioButton Pink;


    private TextView ScoreTextView;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar_score);

        // Take info from user and print in TextView
        String babyName = getIntent().getStringExtra("name");
        TextView babyNameTextView = findViewById(R.id.babyName);

        babyNameTextView.setText(babyName);

        // Start timer after clicking Save in create_new page
        timerTextView = findViewById(R.id.timerTextView);

        // Find All RadioButtons
        // Declare All RadioButtons
        More100Radio = findViewById(R.id.More100);
        Less100Radio = findViewById(R.id.Less100);
        WeakBreathing = findViewById(R.id.WeakBreathing);
        StrongBreathing = findViewById(R.id.StrongBreathing);
        Some = findViewById(R.id.Some);
        Active = findViewById(R.id.Active);
        Grimace = findViewById(R.id.Grimace);
        ActiveWithdrawal = findViewById(R.id.ActiveWithdrawal);
        Blue = findViewById(R.id.Blue);
        Pink = findViewById(R.id.Pink);


        ScoreTextView = findViewById(R.id.ScoreTextView);

        Button CalculateButton = findViewById(R.id.CalculateButton);

        CalculateButton.setOnClickListener(v -> {
            int score = calculateScore();

            ScoreTextView.setText("Score: " + score);
        });

        startTimer();
    }

    private int calculateScore() {
        int score = 0;
        if (Less100Radio.isChecked()) {
            score += 1;
        }
        if (More100Radio.isChecked()) {
            score += 2;
        }
        if (WeakBreathing.isChecked()) {
            score += 1;
        }
        if (StrongBreathing.isChecked()) {
            score += 2;
        }
        if (Some.isChecked()) {
            score += 1;
        }
        if (Active.isChecked()) {
            score += 2;
        }
        if (Grimace.isChecked()) {
            score += 1;
        }
        if (ActiveWithdrawal.isChecked()) {
            score += 2;
        }
        if (Blue.isChecked()) {
            score += 1;
        }
        if (Pink.isChecked()) {
            score += 2;
        }
        return score;
    }

    private void startTimer() {
        long totalDuration = 10 * 60 * 1000; // 10 min
        long reminder1Interval = 7 * 60 * 1000; // 7 min
        long reminder2Interval = 3 * 60 * 1000; // 3 min

        CountDownTimer timer = new CountDownTimer(totalDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished/1000;
                long minutes = seconds / 60;
                seconds %= 60;

                String timeRemaining = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

                timerTextView.setText(timeRemaining);

                if(millisUntilFinished == reminder1Interval) {
                    showReminder("Second Apgar score");
                } else if (millisUntilFinished == reminder2Interval) {
                    showReminder("third Apgar Score");
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                timerTextView.setText("Timer Finished!");
            }
        };

        timer.start();
    }

    private void showReminder(String reminderMessage) {
        Toast.makeText(ApgarScore.this, reminderMessage, Toast.LENGTH_SHORT).show();
    }
}
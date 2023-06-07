package com.example.apgarapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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

    private RadioButton Absent;
    private RadioButton Less100Radio;
    private RadioButton More100Radio;
    private RadioButton NonBreathing;
    private RadioButton WeakBreathing;
    private RadioButton StrongBreathing;
    private RadioButton Limp;
    private RadioButton Some;
    private RadioButton Active;
    private RadioButton Non;
    private RadioButton Grimace;
    private RadioButton ActiveWithdrawal;
    private RadioButton Pale;

    private RadioButton Blue;
    private RadioButton Pink;

    private static final String PREFS_NAME = "ApgarPrefs";
    private static final String KEY_SCORE = "score";
    private static final String KEY_RADIO_SELECTION = "radio_selection";
    private TextView Apgar1Score;
    private TextView Apgar2Score;
    private TextView Apgar3Score;
    private SharedPreferences sharedPreferences;
    private int currentPhase = 1;
    private boolean isSaveEnabled = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar_score);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Take info from user and print in TextView
        String babyName = getIntent().getStringExtra("name");
        TextView babyNameTextView = findViewById(R.id.babyName);

        babyNameTextView.setText(babyName);

        // Start timer after clicking Save in create_new page
        timerTextView = findViewById(R.id.timerTextView);

        // Find All RadioButtons
        // Declare All RadioButtons
        Absent = findViewById(R.id.Absent);
        More100Radio = findViewById(R.id.More100);
        Less100Radio = findViewById(R.id.Less100);
        NonBreathing = findViewById(R.id.NonBreathing);
        WeakBreathing = findViewById(R.id.WeakBreathing);
        StrongBreathing = findViewById(R.id.StrongBreathing);
        Limp = findViewById(R.id.Limp);
        Some = findViewById(R.id.Some);
        Active = findViewById(R.id.Active);
        Non = findViewById(R.id.Non);
        Grimace = findViewById(R.id.Grimace);
        ActiveWithdrawal = findViewById(R.id.ActiveWithdrawal);
        Pale = findViewById(R.id.Pale);
        Blue = findViewById(R.id.Blue);
        Pink = findViewById(R.id.Pink);

        restoreRadioSelections();

        Apgar1Score = findViewById(R.id.Apgar1Score);
        Apgar2Score = findViewById(R.id.Apgar2Score);
        Apgar3Score = findViewById(R.id.Apgar3Score);

        setRadioButtonListeners();

        Button SaveButton = findViewById(R.id.SaveButton);

        SaveButton.setOnClickListener(v -> {
            if (isSaveEnabled) {
                Intent intent = new Intent(ApgarScore.this, CheckBabyInfo.class);
                startActivity(intent);
            } else {
                Toast.makeText(ApgarScore.this, "Please wait until fill 3th Apgar scores.", Toast.LENGTH_SHORT).show();
            }
        });

        startTimer();
    }
    private void setRadioButtonListeners() {
        Absent.setOnClickListener(v -> calculateAndDisplayScore());
        Less100Radio.setOnClickListener(v -> calculateAndDisplayScore());
        More100Radio.setOnClickListener(v -> calculateAndDisplayScore());
        NonBreathing.setOnClickListener(v -> calculateAndDisplayScore());
        WeakBreathing.setOnClickListener(v -> calculateAndDisplayScore());
        StrongBreathing.setOnClickListener(v -> calculateAndDisplayScore());
        Limp.setOnClickListener(v -> calculateAndDisplayScore());
        Some.setOnClickListener(v -> calculateAndDisplayScore());
        Active.setOnClickListener(v -> calculateAndDisplayScore());
        Non.setOnClickListener(v -> calculateAndDisplayScore());
        Grimace.setOnClickListener(v -> calculateAndDisplayScore());
        ActiveWithdrawal.setOnClickListener(v -> calculateAndDisplayScore());
        Pale.setOnClickListener(v -> calculateAndDisplayScore());
        Blue.setOnClickListener(v -> calculateAndDisplayScore());
        Pink.setOnClickListener(v -> calculateAndDisplayScore());

    }
    private void restoreRadioSelections() {
        int savedSelections = sharedPreferences.getInt(KEY_RADIO_SELECTION, -1);

        if (savedSelections != -1) {
            RadioButton selectedRadioButton  = findViewById(savedSelections);
            selectedRadioButton.setChecked(true);
        }
    }
    private void saveRadioSelection(int selectedId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_RADIO_SELECTION, selectedId);
        editor.apply();
    }
    @Override
    protected void onPause() {
        super.onPause();
        int selectedId = getSelectedRadioButtonId();
        saveRadioSelection(selectedId);
    }
    private int getSelectedRadioButtonId() {
        if (Absent.isChecked()) {
            return R.id.Absent;
        } else if (Less100Radio.isChecked()) {
            return R.id.Less100;
        } else if (More100Radio.isChecked()) {
            return R.id.More100;
        } else if (NonBreathing.isChecked()) {
            return R.id.NonBreathing;
        }else if (WeakBreathing.isChecked()) {
            return R.id.WeakBreathing;
        } else if (StrongBreathing.isChecked()) {
            return R.id.StrongBreathing;
        } else if (Limp.isChecked()) {
            return R.id.Limp;
        }else if (Some.isChecked()) {
            return R.id.Some;
        } else if (Active.isChecked()) {
            return R.id.Active;
        } else if (Non.isChecked()) {
            return R.id.Non;
        }else if (Grimace.isChecked()) {
            return R.id.Grimace;
        } else if (ActiveWithdrawal.isChecked()) {
            return R.id.ActiveWithdrawal;
        } else if (Pale.isChecked()) {
            return R.id.Pale;
        }else if (Blue.isChecked()) {
            return R.id.Blue;
        } else if (Pink.isChecked()) {
            return R.id.Pink;
        }
        return -1;
    }
    @SuppressLint("SetTextI18n")
    private void calculateAndDisplayScore() {
        int score = calculateScore();
        if (currentPhase == 1) {
            Apgar1Score.setText("Score: " + score);
        } else if (currentPhase == 2) {
            Apgar2Score.setText("Score: " + score);
        } else if (currentPhase == 3) {
            Apgar3Score.setText("Score: " + score);
        }
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
        long totalDuration = 2 * 60 * 1000; // 2 min
        long phase1Interval = 60 * 1000 + 30 * 1000; // 9 min
        long phase2Interval = 60 * 1000; // 6 min
        long toastDuration = 10 * 1000;

        CountDownTimer timer = new CountDownTimer(totalDuration, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds %= 60;

                String timeRemaining = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                timerTextView.setText(timeRemaining);

                if (millisUntilFinished > phase1Interval) {
                    if (currentPhase == 0) {
                        showReminder("First Apgar Score");
                        if (millisUntilFinished <= (phase1Interval + toastDuration)) {
                            showReminder("First Apgar Score - 10 seconds remaining");
                        }
                        currentPhase = 1;
                        resetRadioButtons();
                        calculateAndDisplayScore();
                    }
                } else if (millisUntilFinished > phase2Interval) {
                    if (currentPhase == 1) {
                        showReminder("Second Apgar Score");
                        if (millisUntilFinished <= (phase2Interval + toastDuration)) {
                            showReminder("Second Apgar Score - 10 seconds remaining");
                        }
                        currentPhase = 2;
                        resetRadioButtons();
                        calculateAndDisplayScore();
                    }
                } else {
                    if (currentPhase == 2) {
                        isSaveEnabled = true;
                        showReminder("Third Apgar Score");
                        if (millisUntilFinished <= toastDuration) {
                            showReminder("Third Apgar Score - 10 seconds remaining");
                        }
                        currentPhase = 3;
                        resetRadioButtons();
                        calculateAndDisplayScore();
                    }
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
                Toast.makeText(ApgarScore.this, "Timer finished!", Toast.LENGTH_SHORT).show();
            }
        };
        timer.start();
    }
    private void showReminder(String reminderMessage) {
        Toast.makeText(ApgarScore.this, reminderMessage, Toast.LENGTH_SHORT).show();
    }
    private void resetRadioButtons() {
        Absent.setChecked(false);
        Less100Radio.setChecked(false);
        More100Radio.setChecked(false);
        NonBreathing.setChecked(false);
        WeakBreathing.setChecked(false);
        StrongBreathing.setChecked(false);
        Limp.setChecked(false);
        Some.setChecked(false);
        Active.setChecked(false);
        Non.setChecked(false);
        Grimace.setChecked(false);
        ActiveWithdrawal.setChecked(false);
        Pale.setChecked(false);
        Blue.setChecked(false);
        Pink.setChecked(false);
    }
}
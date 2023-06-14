package com.example.apgarapp;

import android.annotation.SuppressLint;
import android.content.Intent;
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
    private String heartRateRadios;
    private String respiratoryRadios;
    private String muscleToneRadios;
    private String reflexRadios;
    private String colorRadios;
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

    private TextView Apgar1Score;
    private TextView Apgar2Score;
    private TextView Apgar3Score;
    private int currentPhase = 1;
    private boolean isSaveEnabled = false;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apgar_score);


        // Take info from user and print in TextView
        String name = UserInfoManager.getInstance().getName();
        TextView babyNameTextView = findViewById(R.id.babyName);

        babyNameTextView.setText(name);

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
    @SuppressLint("SetTextI18n")
    private void calculateAndDisplayScore() {
        int score = calculateScore();
        TextView Review = findViewById(R.id.ShortReview);
        if (currentPhase == 1) {
            Apgar1Score.setText("Score: " + score);
            UserApgarScore.getInstance().setHeartRatePhase1(heartRateRadios);
            UserApgarScore.getInstance().setRespiratoryPhase1(respiratoryRadios);
            UserApgarScore.getInstance().setMuscleTonePhase1(muscleToneRadios);
            UserApgarScore.getInstance().setReflexPhase1(reflexRadios);
            UserApgarScore.getInstance().setColorPhase1(colorRadios);
            UserApgarScore.getInstance().setScore1(score);
            if (score >= 0 && score <=2) {
                String Review1 = "Poor";
                UserApgarScore.getInstance().setReview1(Review1);
                Review.setText("Review : " + Review1);
            }
            if ( score == 3) {
                String Review1 = "Fair";
                UserApgarScore.getInstance().setReview1(Review1);
                Review.setText("Review : " + Review1);
            }
            if ( score >= 4 && score <= 6) {
                String Review1 = "Normal";
                UserApgarScore.getInstance().setReview1(Review1);
                Review.setText("Review : " + Review1);
            }
            if ( score == 7) {
                String Review1 = "Good";
                UserApgarScore.getInstance().setReview1(Review1);
                Review.setText("Review : " + Review1);
            }
            if ( score >= 8 && score <= 10) {
                String Review1 = "Excellent";
                UserApgarScore.getInstance().setReview1(Review1);
                Review.setText("Review : " + Review1);
            }
        } else if (currentPhase == 2) {
            Apgar2Score.setText("Score: " + score);
            UserApgarScore.getInstance().setHeartRatePhase2(heartRateRadios);
            UserApgarScore.getInstance().setRespiratoryPhase2(respiratoryRadios);
            UserApgarScore.getInstance().setMuscleTonePhase2(muscleToneRadios);
            UserApgarScore.getInstance().setReflexPhase2(reflexRadios);
            UserApgarScore.getInstance().setColorPhase2(colorRadios);
            UserApgarScore.getInstance().setScore2(score);
            if (score >= 0 && score <=2) {
                String Review2 = "Poor";
                UserApgarScore.getInstance().setReview2(Review2);
                Review.setText("Review : " + Review2);
            }
            if ( score == 3) {
                String Review2 = "Fair";
                UserApgarScore.getInstance().setReview2(Review2);
                Review.setText("Review : " + Review2);
            }
            if ( score >= 4 && score <= 6) {
                String Review2 = "Normal";
                UserApgarScore.getInstance().setReview2(Review2);
                Review.setText("Review : " + Review2);
            }
            if ( score == 7) {
                String Review2 = "Good";
                UserApgarScore.getInstance().setReview2(Review2);
                Review.setText("Review : " + Review2);
            }
            if ( score >= 8 && score <= 10) {
                String Review2 = "Excellent";
                UserApgarScore.getInstance().setReview2(Review2);
                Review.setText("Review : " + Review2);
            }
        } else if (currentPhase == 3) {
            Apgar3Score.setText("Score: " + score);
            UserApgarScore.getInstance().setHeartRatePhase3(heartRateRadios);
            UserApgarScore.getInstance().setRespiratoryPhase3(respiratoryRadios);
            UserApgarScore.getInstance().setMuscleTonePhase3(muscleToneRadios);
            UserApgarScore.getInstance().setReflexPhase3(reflexRadios);
            UserApgarScore.getInstance().setColorPhase3(colorRadios);
            UserApgarScore.getInstance().setScore3(score);
            if (score >= 0 && score <=2) {
                String Review3 = "Poor";
                UserApgarScore.getInstance().setReview3(Review3);
                Review.setText("Review : " + Review3);
            }
            if ( score == 3) {
                String Review3 = "Fair";
                UserApgarScore.getInstance().setReview3(Review3);
                Review.setText("Review : " + Review3);
            }
            if ( score >= 4 && score <= 6) {
                String Review3 = "Normal";
                UserApgarScore.getInstance().setReview3(Review3);
                Review.setText("Review : " + Review3);
            }
            if ( score == 7) {
                String Review3 = "Good";
                UserApgarScore.getInstance().setReview3(Review3);
                Review.setText("Review : " + Review3);
            }
            if ( score >= 8 && score <= 10) {
                String Review3 = "Excellent";
                UserApgarScore.getInstance().setReview3(Review3);
                Review.setText("Review : " + Review3);
            }
        }

    }
    private int calculateScore() {
        int score = 0;
        if (Absent.isChecked()) {
            heartRateRadios = "Absent";
        }
        if (Less100Radio.isChecked()) {
            heartRateRadios = "<100";
            score += 1;
        }
        if (More100Radio.isChecked()) {
            heartRateRadios = ">100";
            score += 2;
        }
        if (NonBreathing.isChecked()) {
            respiratoryRadios = "NonBreathing";
        }
        if (WeakBreathing.isChecked()) {
            respiratoryRadios = "WeakBreathing";
            score += 1;
        }
        if (StrongBreathing.isChecked()) {
            respiratoryRadios = "StrongBreathing";
            score += 2;
        }
        if (Limp.isChecked()) {
            muscleToneRadios = "Limp";
        }
        if (Some.isChecked()) {
            muscleToneRadios = "Some";
            score += 1;
        }
        if (Active.isChecked()) {
            muscleToneRadios = "Active";
            score += 2;
        }
        if (Non.isChecked()) {
            reflexRadios = "Non";
        }
        if (Grimace.isChecked()) {
            reflexRadios = "Grimace";
            score += 1;
        }
        if (ActiveWithdrawal.isChecked()) {
            reflexRadios = "Active";
            score += 2;
        }
        if (Pale.isChecked()) {
            colorRadios = "Pale";
        }
        if (Blue.isChecked()) {
            colorRadios = "Blue";
            score += 1;
        }
        if (Pink.isChecked()) {
            colorRadios = "Pink";
            score += 2;
        }
        return score;
    }
    private void startTimer() {
        long totalDuration = 10 * 60 * 1000; // 10 min
        long phase1Interval = 7 * 60 * 1000; // 7 min
        long phase2Interval = 4 * 60 * 1000; // 4 min
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
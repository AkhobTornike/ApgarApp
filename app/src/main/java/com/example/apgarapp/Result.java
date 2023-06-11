package com.example.apgarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String HeartRate1 = UserApgarScore.getInstance().getHeartRatePhase1();
        String Respiratory1 = UserApgarScore.getInstance().getRespiratoryPhase1();
        String MuscleTone1 = UserApgarScore.getInstance().getMuscleTonePhase1();
        String Reflex1 = UserApgarScore.getInstance().getReflexPhase1();
        String Color1 = UserApgarScore.getInstance().getColorPhase1();

        String HeartRate2 = UserApgarScore.getInstance().getHeartRatePhase2();
        String Respiratory2 = UserApgarScore.getInstance().getRespiratoryPhase2();
        String MuscleTone2 = UserApgarScore.getInstance().getMuscleTonePhase2();
        String Reflex2 = UserApgarScore.getInstance().getReflexPhase2();
        String Color2 = UserApgarScore.getInstance().getColorPhase2();

        String HeartRate3 = UserApgarScore.getInstance().getHeartRatePhase3();
        String Respiratory3 = UserApgarScore.getInstance().getRespiratoryPhase3();
        String MuscleTone3 = UserApgarScore.getInstance().getMuscleTonePhase3();
        String Reflex3 = UserApgarScore.getInstance().getReflexPhase3();
        String Color3 = UserApgarScore.getInstance().getColorPhase3();

        TextView HeartRateScore1 = findViewById(R.id.HeartRateScore1);
        HeartRateScore1.setText(HeartRate1);

        TextView RespiratoryScore1 = findViewById(R.id.RespiratoryScore1);
        RespiratoryScore1.setText(Respiratory1);

        TextView MuscleToneScore1 = findViewById(R.id.MuscleToneScore1);
        MuscleToneScore1.setText(MuscleTone1);

        TextView ReflexScore1 = findViewById(R.id.ReflexScore1);
        ReflexScore1.setText(Reflex1);

        TextView ColorScore1 = findViewById(R.id.ColorScore1);
        ColorScore1.setText(Color1);

        TextView HeartRateScore2 = findViewById(R.id.HeartRateScore2);
        HeartRateScore2.setText(HeartRate2);

        TextView RespiratoryScore2 = findViewById(R.id.RespiratoryScore2);
        RespiratoryScore2.setText(Respiratory2);

        TextView MuscleToneScore2 = findViewById(R.id.MuscleToneScore2);
        MuscleToneScore2.setText(MuscleTone2);

        TextView ReflexScore2 = findViewById(R.id.ReflexScore2);
        ReflexScore2.setText(Reflex2);

        TextView ColorScore2 = findViewById(R.id.ColorScore2);
        ColorScore2.setText(Color2);

        TextView HeartRateScore3 = findViewById(R.id.HeartRateScore3);
        HeartRateScore3.setText(HeartRate3);

        TextView RespiratoryScore3 = findViewById(R.id.RespiratoryScore3);
        RespiratoryScore3.setText(Respiratory3);

        TextView MuscleToneScore3 = findViewById(R.id.MuscleToneScore3);
        MuscleToneScore3.setText(MuscleTone3);

        TextView ReflexScore3 = findViewById(R.id.ReflexScore3);
        ReflexScore3.setText(Reflex3);

        TextView ColorScore3 = findViewById(R.id.ColorScore3);
        ColorScore3.setText(Color3);
    }
}
package com.example.apgarapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ScrollView scrollView = findViewById(R.id.scrollView);

        // Enable scrolling for the ScrollView
        scrollView.setScrollContainer(true);
        scrollView.setVerticalScrollBarEnabled(true);

        Number Score1 = UserApgarScore.getInstance().getScore1();
        Number Score2 = UserApgarScore.getInstance().getScore2();
        Number Score3 = UserApgarScore.getInstance().getScore3();

        String Review1 = UserApgarScore.getInstance().getReview1();
        String Review2 = UserApgarScore.getInstance().getReview2();
        String Review3 = UserApgarScore.getInstance().getReview3();

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

        String Poor = "Poor";
        String Fair = "Fair";
        String Normal = "Normal";
        String Good = "Good";
        String Excellent = "Excellent";

        String PoorFair_Start = "The newborn's initial Apgar score suggested some difficulties requiring immediate attention and specialized care,";
        String PoorFair_Middle = "However, the baby's Apgar score moved towards a normal/good range,";
        String PoorFair_Finish = "The positive trend continues, and the baby's Apgar score improves significantly, reflecting an excellent recovery and a healthy state.";

        String NormalGood_Start = "The newborn's first Apgar score indicated a favorable condition with no immediate concerns,";
        String NormalGood_Middle = "After, the baby's condition remained stable as the Apgar score remained within the normal/good range, indicating continued well-being,";
        String NormalGood_Finish = "In conclusion positive trend continues, and the baby's Apgar score remains consistently normal/good, reflecting a healthy transition and a positive outcome.";

        String Excellent_Start = "The newborn's initial Apgar score demonstrated strong vital signs and a robust start in life,";
        String Excellent_Middle = "After, the excellent Apgar score persisted, indicating the baby's continued healthy condition and adaptability,";
        String Excellent_Finish = "Now Apgar score remains consistently excellent, reflecting the newborn's optimal health and successful transition into the world.";

        TextView Score1Result = findViewById(R.id.Score1Result);
        Score1Result.setText(Score1.toString());

        TextView Score2Result = findViewById(R.id.Score2Result);
        Score2Result.setText(Score2.toString());

        TextView Score3Result = findViewById(R.id.Score3Result);
        Score3Result.setText(Score3.toString());

        TextView Review1Result = findViewById(R.id.Review1Result);
        Review1Result.setText(Review1);

        TextView Review2Result = findViewById(R.id.Review2Result);
        Review2Result.setText(Review2);

        TextView Review3Result = findViewById(R.id.Review3Result);
        Review3Result.setText(Review3);

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

        TextView review = findViewById(R.id.review);
        boolean pf1 = Review1.equals(Poor) || Review1.equals(Fair);
        boolean ng1 = Review1.equals(Normal) || Review1.equals(Good);
        boolean e1 = Review1.equals(Excellent);
        boolean pf2 = Review2.equals(Poor) || Review2.equals(Fair);
        boolean ng2 = Review2.equals(Normal) || Review2.equals(Good);
        boolean e2 = Review2.equals(Excellent);
        boolean pf3 = Review3.equals(Poor) || Review3.equals(Fair);
        boolean ng3 = Review3.equals(Normal) || Review3.equals(Good);
        boolean e3 = Review3.equals(Excellent);
        if (pf1 && pf2 && pf3) {
            review.setText(PoorFair_Start + PoorFair_Middle + PoorFair_Finish);
        }
        if (pf1 && pf2 && ng3) {
            review.setText(PoorFair_Start + PoorFair_Middle + NormalGood_Finish);
        }
        if (pf1 && pf2 && e3) {
            review.setText(PoorFair_Start + PoorFair_Middle + Excellent_Finish);
        }
        if (pf1 && ng2 && pf3) {
            review.setText(PoorFair_Start + NormalGood_Middle + PoorFair_Finish);
        }
        if (pf1 && ng2 && ng3) {
            review.setText(PoorFair_Start + NormalGood_Middle + NormalGood_Finish);
        }
        if (pf1 && ng2 && e3) {
            review.setText(PoorFair_Start + NormalGood_Middle + Excellent_Finish);
        }
        if (pf1 && e2 && pf3) {
            review.setText(PoorFair_Start + Excellent_Middle + PoorFair_Finish);
        }
        if (pf1 && e2 && ng3) {
            review.setText(PoorFair_Start + Excellent_Middle + NormalGood_Finish);
        }
        if (pf1 && e2 && e3) {
            review.setText(PoorFair_Start + Excellent_Middle + Excellent_Finish);
        }

        if (ng1 && pf2 && pf3) {
            review.setText(NormalGood_Start + PoorFair_Middle + PoorFair_Finish);
        }
        if (ng1 && pf2 && ng3) {
            review.setText(NormalGood_Start + PoorFair_Middle + NormalGood_Finish);
        }
        if (ng1 && pf2 && e3) {
            review.setText(NormalGood_Start + PoorFair_Middle + Excellent_Finish);
        }
        if (ng1 && ng2 && pf3) {
            review.setText(NormalGood_Start + NormalGood_Middle + PoorFair_Finish);
        }
        if (ng1 && ng2 && ng3) {
            review.setText(NormalGood_Start + NormalGood_Middle + NormalGood_Finish);
        }
        if (ng1 && ng2 && e3) {
            review.setText(NormalGood_Start + NormalGood_Middle + Excellent_Finish);
        }
        if (ng1 && ng2 && pf3) {
            review.setText(NormalGood_Start + NormalGood_Middle + PoorFair_Finish);
        }
        if (ng1 && e2 && ng3) {
            review.setText(NormalGood_Start + Excellent_Middle + NormalGood_Finish);
        }
        if (ng1 && e2 && e3) {
            review.setText(NormalGood_Start + Excellent_Middle + Excellent_Finish);
        }

        if (e1 && pf2 && pf3) {
            review.setText(Excellent_Start + PoorFair_Middle + PoorFair_Finish);
        }
        if (e1 && pf2 && ng3) {
            review.setText(Excellent_Start + PoorFair_Middle + NormalGood_Finish);
        }
        if (e1 && pf2 && e3) {
            review.setText(Excellent_Start + PoorFair_Middle + Excellent_Finish);
        }
        if (e1 && ng2 && pf3) {
            review.setText(Excellent_Start + NormalGood_Middle + PoorFair_Finish);
        }
        if (e1 && ng2 && ng3) {
            review.setText(Excellent_Start + NormalGood_Middle + NormalGood_Finish);
        }
        if (e1 && ng2 && e3) {
            review.setText(Excellent_Start + NormalGood_Middle + Excellent_Finish);
        }
        if (e1 && e2 && pf3) {
            review.setText(Excellent_Start + Excellent_Middle + PoorFair_Finish);
        }
        if (e1 && e2 && ng3) {
            review.setText(Excellent_Start + Excellent_Middle + NormalGood_Finish);
        }
        if (e1 && e2 && e3) {
            review.setText(Excellent_Start + Excellent_Middle + Excellent_Finish);
        }
    }
}
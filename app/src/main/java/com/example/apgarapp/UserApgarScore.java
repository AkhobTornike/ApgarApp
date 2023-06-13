package com.example.apgarapp;

public class UserApgarScore {
    private static UserApgarScore instance;

    // Phase 1 variables
    private String heartRatePhase1;
    private String respiratoryPhase1;
    private String muscleTonePhase1;
    private String reflexPhase1;
    private String colorPhase1;

    // Phase 2 variables
    private String heartRatePhase2;
    private String respiratoryPhase2;
    private String muscleTonePhase2;
    private String reflexPhase2;
    private String colorPhase2;

    // Phase 3 variables
    private String heartRatePhase3;
    private String respiratoryPhase3;
    private String muscleTonePhase3;
    private String reflexPhase3;
    private String colorPhase3;

    private String review1;
    private String review2;
    private String review3;

    private Number score1;
    private Number score2;
    private Number score3;


    private UserApgarScore() {
        // Private constructor to enforce singleton pattern
    }

    public static UserApgarScore getInstance() {
        if (instance == null) {
            instance = new UserApgarScore();
        }
        return instance;
    }

    // Getters for phase 1 variables
    public String getHeartRatePhase1() {
        return heartRatePhase1;
    }

    public String getRespiratoryPhase1() {
        return respiratoryPhase1;
    }

    public String getMuscleTonePhase1() {
        return muscleTonePhase1;
    }

    public String getReflexPhase1() {
        return reflexPhase1;
    }

    public String getColorPhase1() {
        return colorPhase1;
    }

    // Getters for phase 2 variables
    public String getHeartRatePhase2() {
        return heartRatePhase2;
    }

    public String getRespiratoryPhase2() {
        return respiratoryPhase2;
    }

    public String getMuscleTonePhase2() {
        return muscleTonePhase2;
    }

    public String getReflexPhase2() {
        return reflexPhase2;
    }

    public String getColorPhase2() {
        return colorPhase2;
    }

    // Getters for phase 3 variables
    public String getHeartRatePhase3() {
        return heartRatePhase3;
    }

    public String getRespiratoryPhase3() {
        return respiratoryPhase3;
    }

    public String getMuscleTonePhase3() {
        return muscleTonePhase3;
    }

    public String getReflexPhase3() {
        return reflexPhase3;
    }

    public String getColorPhase3() {
        return colorPhase3;
    }

    public String getReview1() {
        return review1;
    }

    public String getReview2() {
        return review2;
    }

    public String getReview3() {
        return review3;
    }

    public Number getScore1() {
        return score1;
    }

    public Number getScore2() {
        return score2;
    }

    public Number getScore3() {
        return score3;
    }

    // Setters for phase 1 variables
    public void setHeartRatePhase1(String heartRatePhase1) {
        this.heartRatePhase1 = heartRatePhase1;
    }

    public void setRespiratoryPhase1(String respiratoryPhase1) {
        this.respiratoryPhase1 = respiratoryPhase1;
    }

    public void setMuscleTonePhase1(String muscleTonePhase1) {
        this.muscleTonePhase1 = muscleTonePhase1;
    }

    public void setReflexPhase1(String reflexPhase1) {
        this.reflexPhase1 = reflexPhase1;
    }

    public void setColorPhase1(String colorPhase1) {
        this.colorPhase1 = colorPhase1;
    }

    // Setters for phase 2 variables
    public void setHeartRatePhase2(String heartRatePhase2) {
        this.heartRatePhase2 = heartRatePhase2;
    }

    public void setRespiratoryPhase2(String respiratoryPhase2) {
        this.respiratoryPhase2 = respiratoryPhase2;
    }

    public void setMuscleTonePhase2(String muscleTonePhase2) {
        this.muscleTonePhase2 = muscleTonePhase2;
    }

    public void setReflexPhase2(String reflexPhase2) {
        this.reflexPhase2 = reflexPhase2;
    }

    public void setColorPhase2(String colorPhase2) {
        this.colorPhase2 = colorPhase2;
    }

    // Setters for phase 3 variables
    public void setHeartRatePhase3(String heartRatePhase3) {
        this.heartRatePhase3 = heartRatePhase3;
    }

    public void setRespiratoryPhase3(String respiratoryPhase3) {
        this.respiratoryPhase3 = respiratoryPhase3;
    }

    public void setMuscleTonePhase3(String muscleTonePhase3) {
        this.muscleTonePhase3 = muscleTonePhase3;
    }

    public void setReflexPhase3(String reflexPhase3) {
        this.reflexPhase3 = reflexPhase3;
    }

    public void setColorPhase3(String colorPhase3) {
        this.colorPhase3 = colorPhase3;
    }

    public void setReview1(String review1) {
        this.review1 = review1;
    }

    public void setReview2(String review2) {
        this.review2 = review2;
    }

    public void setReview3(String review3) {
        this.review3 = review3;
    }

    public void setScore1(Number score1) {
        this.score1 = score1;
    }

    public void setScore2(Number score2) {
        this.score2 = score2;
    }

    public void setScore3(Number score3) {
        this.score3 = score3;
    }
}

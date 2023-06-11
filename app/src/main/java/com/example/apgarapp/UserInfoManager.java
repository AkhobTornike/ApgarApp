package com.example.apgarapp;

public class UserInfoManager {
    private static UserInfoManager instance;
    private String name;
    private String id;
    private String date;

    private UserInfoManager() {

    }

    public static UserInfoManager getInstance() {
        if (instance == null) {
            instance = new UserInfoManager();
        }
        return instance;
    }

    public void saveUserInfo(String name, String id, String date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

}

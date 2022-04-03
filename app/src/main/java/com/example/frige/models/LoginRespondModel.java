package com.example.frige.models;

public class LoginRespondModel {
    private int userID;
    private String email;

    public LoginRespondModel(int userID, String email) {
        this.userID = userID;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

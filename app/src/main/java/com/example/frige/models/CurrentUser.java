package com.example.frige.models;

public class CurrentUser {
    private static CurrentUser instance;
    private int CurrentUserID;

    private CurrentUser() {
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public int getCurrentUserID() {
        return CurrentUserID;
    }

    public void setCurrentUserID(int currentUserID) {
        CurrentUserID = currentUserID;
    }
}

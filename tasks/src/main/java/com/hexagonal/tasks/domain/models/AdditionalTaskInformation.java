package com.hexagonal.tasks.domain.models;

public class AdditionalTaskInformation {
    private final long userId;
    private final String username;
    private final String userEmail;

    public AdditionalTaskInformation(long userId, String username, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserEmail() {
        return userEmail;
    }
}

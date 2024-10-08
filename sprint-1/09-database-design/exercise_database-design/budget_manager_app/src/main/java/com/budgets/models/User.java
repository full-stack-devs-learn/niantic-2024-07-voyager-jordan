package com.budgets.models;

public class User {
    private int userId;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;

    public User(){}
    public User(int userId, String first_name, String last_name)
    {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //<editor-fold desc="Getters & Setters">
    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //</editor-fold>
    @Override
    public String toString()
    {
        return String.format("%3d %10s %10s", userId, first_name, last_name);
    }
}

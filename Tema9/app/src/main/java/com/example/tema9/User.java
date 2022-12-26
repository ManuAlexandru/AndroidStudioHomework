package com.example.tema9;

import androidx.annotation.NonNull;

public class User {
    private int id;
    private String Name;
    private String Age;
    private String UserClass;

    public int getId() {
        return id;
    }

    public User(int id, String name, String age, String userClass) {
        this.id = id;
        Name = name;
        Age = age;
        UserClass = userClass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getUserClass() {
        return UserClass;
    }

    public void setUserClass(String userClass) {
        UserClass = userClass;
    }
}

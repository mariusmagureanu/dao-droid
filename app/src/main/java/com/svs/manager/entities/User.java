package com.svs.manager.entities;

import android.content.ContentValues;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class User extends BaseEntity {

    public static String TABLE_NAME = "user";
    public static String FIRST_NAME_COLUMN = "first_name";
    public static String LAST_NAME_COLUMN = "last_name";
    public static String USER_NAME_COLUMN = "user_name";
    public static String PASSWORD_COLUMN = "password";

    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public ContentValues asContentValues() {
        return null;
    }
}

package com.revconnect.model;


public abstract class User {
protected int id;
protected String email;
protected String password;
protected String name;
protected String bio;


public abstract String getUserType();
}
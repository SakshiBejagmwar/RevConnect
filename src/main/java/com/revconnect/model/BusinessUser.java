package com.revconnect.model;


public class BusinessUser extends User {
@SuppressWarnings("unused")
private String address;


@Override
public String getUserType() {
return "BUSINESS";
}
}
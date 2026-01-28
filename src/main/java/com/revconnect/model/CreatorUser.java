package com.revconnect.model;


public class CreatorUser extends User {
@SuppressWarnings("unused")
private String category;


@Override
public String getUserType() {
return "CREATOR";
}
}
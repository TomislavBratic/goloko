package com.example.goloko.enums;


public enum Roles {
    ADMIN("admin"),
    CLIENT("client"),
    USER("user");

    private final String roleName;

    private Roles(String roleName){
        this.roleName=roleName;
    }

    public String getRoleName(){
        return roleName;
    }
}

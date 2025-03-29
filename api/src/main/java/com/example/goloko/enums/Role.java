package com.example.goloko.enums;

public enum Role {
    ADMIN("admin"),
    CLIENT("client"),
    USER("user");

    private final String roleName;

    Role(String roleName){
        this.roleName=roleName;
    }

    public String getRoleName(){
        return roleName;
    }
}

package com.example.goloko.enums;

public enum SubscriptionStatus {
    ACTIVE("active"),
    PENDING("pending"),
    EXPIRED("expired");

    private final String statusName;

    SubscriptionStatus(String roleName){
        this.statusName=roleName;
    }

    public String getStatusName(){
        return statusName;
    }
}


package com.example.goloko.enums;

public enum PaymentStatus {
    COMPLETED("completed"),
    PENDING("pending"),
    FAILED("failed");

    private final String statusName;

    PaymentStatus(String statusName){
        this.statusName=statusName;
    }

    public String getStatusName(){
        return statusName;
    }
}

package com.example.goloko.enums;

public enum AttendeeStatus {

    ATTENDING("attending"),
    INTERESTED("interested"),
    DECLINED("declined");

    private final String status;

    AttendeeStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}

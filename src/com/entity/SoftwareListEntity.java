package com.entity;

public class SoftwareListEntity {
    private  SoftwareEntity softwareEntity;
    private  String username;

    public SoftwareEntity getSoftwareEntity() {
        return softwareEntity;
    }

    public void setSoftwareEntity(SoftwareEntity softwareEntity) {
        this.softwareEntity = softwareEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

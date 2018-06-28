package com.entity;

public class TeacherListEntity {
    private UserEntity userEntity;
    private String WorkroomName;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getWorkroomName() {
        return WorkroomName;
    }

    public void setWorkroomName(String workroomName) {
        WorkroomName = workroomName;
    }
}

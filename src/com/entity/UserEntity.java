package com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "studiofile", catalog = "")
public class UserEntity {
    private int uId;
    private int wId;
    private String uAccount;
    private String uPassword;
    private String uName;
    private String uClass;
    private String uGrade;
    private int uType;

    @Id
    @Column(name = "u_id", nullable = false)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "w_id", nullable = false)
    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    @Basic
    @Column(name = "u_account", nullable = false, length = 45)
    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    @Basic
    @Column(name = "u_password", nullable = false, length = 45)
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Basic
    @Column(name = "u_name", nullable = false, length = 11)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_class", nullable = true, length = 20)
    public String getuClass() {
        return uClass;
    }

    public void setuClass(String uClass) {
        this.uClass = uClass;
    }

    @Basic
    @Column(name = "u_grade", nullable = true, length = 10)
    public String getuGrade() {
        return uGrade;
    }

    public void setuGrade(String uGrade) {
        this.uGrade = uGrade;
    }

    @Basic
    @Column(name = "u_type", nullable = false)
    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uId == that.uId &&
                wId == that.wId &&
                uType == that.uType &&
                Objects.equals(uAccount, that.uAccount) &&
                Objects.equals(uPassword, that.uPassword) &&
                Objects.equals(uName, that.uName) &&
                Objects.equals(uClass, that.uClass) &&
                Objects.equals(uGrade, that.uGrade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uId, wId, uAccount, uPassword, uName, uClass, uGrade, uType);
    }
}

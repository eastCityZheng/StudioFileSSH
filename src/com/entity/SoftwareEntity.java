package com.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "software", schema = "studiofile", catalog = "")
public class SoftwareEntity {
    private int sId;
    private int uId;
    private String sName;
    private Date sTime;
    private String sSoftware;
    private String sVersion;

    @Id
    @Column(name = "s_id", nullable = false)
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "u_id", nullable = false)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "s_name", nullable = false, length = 45)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "s_time", nullable = false)
    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    @Basic
    @Column(name = "s_software", nullable = true, length = 200)
    public String getsSoftware() {
        return sSoftware;
    }

    public void setsSoftware(String sSoftware) {
        this.sSoftware = sSoftware;
    }

    @Basic
    @Column(name = "s_version", nullable = true, length = 45)
    public String getsVersion() {
        return sVersion;
    }

    public void setsVersion(String sVersion) {
        this.sVersion = sVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEntity that = (SoftwareEntity) o;
        return sId == that.sId &&
                uId == that.uId &&
                Objects.equals(sName, that.sName) &&
                Objects.equals(sTime, that.sTime) &&
                Objects.equals(sSoftware, that.sSoftware) &&
                Objects.equals(sVersion, that.sVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sId, uId, sName, sTime, sSoftware, sVersion);
    }
}

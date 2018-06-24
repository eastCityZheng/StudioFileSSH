package com.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "projectfile", schema = "studiofile", catalog = "")
public class ProjectfileEntity {
    private int pId;
    private int uId;
    private String pWord;
    private String pCode;
    private String pName;
    private String pVideo;
    private Date pTime;

    @Id
    @Column(name = "p_id", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
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
    @Column(name = "p_word", nullable = true, length = 200)
    public String getpWord() {
        return pWord;
    }

    public void setpWord(String pWord) {
        this.pWord = pWord;
    }

    @Basic
    @Column(name = "p_code", nullable = true, length = 200)
    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @Basic
    @Column(name = "p_name", nullable = true, length = 45)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Basic
    @Column(name = "p_video", nullable = true, length = 200)
    public String getpVideo() {
        return pVideo;
    }

    public void setpVideo(String pVideo) {
        this.pVideo = pVideo;
    }

    @Basic
    @Column(name = "p_time", nullable = false)
    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectfileEntity that = (ProjectfileEntity) o;
        return pId == that.pId &&
                uId == that.uId &&
                Objects.equals(pWord, that.pWord) &&
                Objects.equals(pCode, that.pCode) &&
                Objects.equals(pName, that.pName) &&
                Objects.equals(pVideo, that.pVideo) &&
                Objects.equals(pTime, that.pTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pId, uId, pWord, pCode, pName, pVideo, pTime);
    }
}

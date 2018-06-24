package com.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "competition", schema = "studiofile", catalog = "")
public class CompetitionEntity {
    private int cId;
    private int uId;
    private Date cTime;
    private String cWord;
    private String cCode;
    private String cName;
    private String cCertificate;
    private String cVideo;

    @Id
    @Column(name = "c_id", nullable = false)
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
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
    @Column(name = "c_time", nullable = false)
    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Basic
    @Column(name = "c_word", nullable = true, length = 200)
    public String getcWord() {
        return cWord;
    }

    public void setcWord(String cWord) {
        this.cWord = cWord;
    }

    @Basic
    @Column(name = "c_code", nullable = true, length = 200)
    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    @Basic
    @Column(name = "c_name", nullable = false, length = 45)
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "c_certificate", nullable = true, length = 200)
    public String getcCertificate() {
        return cCertificate;
    }

    public void setcCertificate(String cCertificate) {
        this.cCertificate = cCertificate;
    }

    @Basic
    @Column(name = "c_video", nullable = true, length = 200)
    public String getcVideo() {
        return cVideo;
    }

    public void setcVideo(String cVideo) {
        this.cVideo = cVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionEntity that = (CompetitionEntity) o;
        return cId == that.cId &&
                uId == that.uId &&
                Objects.equals(cTime, that.cTime) &&
                Objects.equals(cWord, that.cWord) &&
                Objects.equals(cCode, that.cCode) &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(cCertificate, that.cCertificate) &&
                Objects.equals(cVideo, that.cVideo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cId, uId, cTime, cWord, cCode, cName, cCertificate, cVideo);
    }
}

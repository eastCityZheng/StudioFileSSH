package com.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "activity", schema = "studiofile", catalog = "")
public class ActivityEntity {
    private int aId;
    private String aName;
    private Date aTime;
    private String aFile;

    @Id
    @Column(name = "a_id", nullable = false)
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Basic
    @Column(name = "a_name", nullable = false, length = 45)
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Basic
    @Column(name = "a_time", nullable = false)
    public Date getaTime() {
        return aTime;
    }

    public void setaTime(Date aTime) {
        this.aTime = aTime;
    }

    @Basic
    @Column(name = "a_file", nullable = false, length = 200)
    public String getaFile() {
        return aFile;
    }

    public void setaFile(String aFile) {
        this.aFile = aFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityEntity that = (ActivityEntity) o;
        return aId == that.aId &&
                Objects.equals(aName, that.aName) &&
                Objects.equals(aTime, that.aTime) &&
                Objects.equals(aFile, that.aFile);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aId, aName, aTime, aFile);
    }
}

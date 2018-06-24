package com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "studiofile", catalog = "")
public class BookEntity {
    private int bId;
    private String bName;
    private int bStatus;
    private String bProvide;
    private Integer uId;
    private int wId;

    @Id
    @Column(name = "b_id", nullable = false)
    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    @Basic
    @Column(name = "b_name", nullable = false, length = 45)
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Basic
    @Column(name = "b_status", nullable = false)
    public int getbStatus() {
        return bStatus;
    }

    public void setbStatus(int bStatus) {
        this.bStatus = bStatus;
    }

    @Basic
    @Column(name = "b_provide", nullable = false, length = 45)
    public String getbProvide() {
        return bProvide;
    }

    public void setbProvide(String bProvide) {
        this.bProvide = bProvide;
    }

    @Basic
    @Column(name = "u_id", nullable = true)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bId == that.bId &&
                bStatus == that.bStatus &&
                wId == that.wId &&
                Objects.equals(bName, that.bName) &&
                Objects.equals(bProvide, that.bProvide) &&
                Objects.equals(uId, that.uId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bId, bName, bStatus, bProvide, uId, wId);
    }
}

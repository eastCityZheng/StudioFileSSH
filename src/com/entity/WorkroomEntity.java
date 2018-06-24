package com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "workroom", schema = "studiofile", catalog = "")
public class WorkroomEntity {
    private int wId;
    private String wName;

    @Id
    @Column(name = "w_id", nullable = false)
    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    @Basic
    @Column(name = "w_name", nullable = false, length = 45)
    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkroomEntity that = (WorkroomEntity) o;
        return wId == that.wId &&
                Objects.equals(wName, that.wName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wId, wName);
    }
}

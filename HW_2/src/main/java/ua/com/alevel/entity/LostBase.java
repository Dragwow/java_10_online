package ua.com.alevel.entity;

import java.util.Date;

public abstract class LostBase {

    private int lostId;
    private Date lostCreated;

    public int getLostId() {
        return lostId;
    }
    public void setLostId(int lostId) {
        this.lostId = lostId;
    }
    public Date getLostCreated() {
        return lostCreated;
    }
    public void setLostCreated(Date lostCreated) {
        this.lostCreated = lostCreated;
    }
}
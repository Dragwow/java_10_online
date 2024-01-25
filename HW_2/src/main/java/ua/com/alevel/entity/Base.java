package ua.com.alevel.entity;

import java.util.Date;

public abstract class Base {

    private int id;
    private Date created;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}
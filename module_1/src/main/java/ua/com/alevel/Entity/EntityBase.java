package ua.com.alevel.Entity;

import java.util.Date;

public class EntityBase {
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

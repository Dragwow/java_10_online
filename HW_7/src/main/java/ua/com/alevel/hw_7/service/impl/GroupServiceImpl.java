package ua.com.alevel.hw_7.service.impl;

import ua.com.alevel.hw_7.db.DBResource;
import ua.com.alevel.hw_7.entity.Group;
import ua.com.alevel.hw_7.service.GroupService;

import java.util.Collection;

public class GroupServiceImpl implements GroupService {

    private final static DBResource dbResource = DBResource.getInstance();
    @Override
    public void create(Group entity) {
        dbResource.createGroup(entity);
    }

    @Override
    public void update(Group entity) {
        dbResource.updateGroup(entity);
    }

    @Override
    public void delete(String id) {
        dbResource.deleteGroup(id);
    }

    @Override
    public Group findById(String id) {
        return dbResource.findGroupById(id);
    }

    @Override
    public Collection<Group> findAll() {
        return dbResource.findAllGroup();
    }
}

package ua.com.alevel.hw_7.service;

import ua.com.alevel.hw_7.entity.Base;

import java.util.Collection;

public interface CrudService <E extends Base> {

    void create(E entity);
    void update(E entity);
    void delete(String id);
    E findById(String id);
    Collection<E> findAll();

}

package ua.com.alevel.hw_7.service.impl;

import ua.com.alevel.hw_7.db.DBResource;
import ua.com.alevel.hw_7.entity.Account;
import ua.com.alevel.hw_7.service.AccountService;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {

    private final DBResource dbResource = DBResource.getInstance();

    @Override
    public void create(Account entity){
        dbResource.createAcc(entity);
    }

    @Override
    public void update(Account entity) {
        dbResource.updateAcc(entity);
    }

    @Override
    public void delete(String id) {
        dbResource.deleteAcc(id);
    }

    @Override
    public Account findById(String id) {
        return dbResource.findAccById(id);
    }

    @Override
    public Collection<Account> findAll() {
       return dbResource.findAllAcc();
    }

}

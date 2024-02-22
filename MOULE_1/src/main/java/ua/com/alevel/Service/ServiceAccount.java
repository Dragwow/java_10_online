package ua.com.alevel.Service;

import ua.com.alevel.Entity.Account;
import ua.com.alevel.db.AccountGroupRelation;

public class ServiceAccount {

    private final AccountGroupRelation db = AccountGroupRelation.getInstance();

    public void create(Account account) {
        if (account.getFirstName() != null && account.getLastName() != null && account.getSurName() != null &&
                account.getAge() > 0) {
            db.create(account);
        }
    }

    public Account[] showAll(){
        return db.showAll();
    }

    public Account findByPasswordAndLogin(String login, String password){
        return db.findByPasswordAndLogin(login, password);
    }

    public void update(Account account){
        Account current = db.findByPasswordAndLogin(account.getLogin(), account.getPassword());
        if (current != null) {
            db.update(account);
        }
    }

    public void reset(Account account){
        Account current = db.findByPasswordAndLogin(account.getLogin(), account.getPassword());
        if (current != null) {
            db.update(account);
        }
    }

    public void delete(String login, String password) {
        Account current = db.findByPasswordAndLogin(login, password);
        if (current != null ) {
            db.delete(login, password);
        }
    }

    public Account findAccountById(String id) {
        return db.findAccountById(id);
    }
}

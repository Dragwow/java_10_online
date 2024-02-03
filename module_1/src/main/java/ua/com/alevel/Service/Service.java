package ua.com.alevel.Service;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.db.dbAccount;
import ua.com.alevel.db.dbCredit;
public class Service {

    dbAccount dbAccount = new dbAccount();
    dbCredit dbCredit = new dbCredit();
    public void create(EntityData entityData) {
        if (entityData.getFirstName() != null && entityData.getLastName() != null && entityData.getSurName() != null
            && entityData.getDayOfBirth() != 0 && entityData.getMonthOfBirth() != 0 && entityData.getYearOfBirth() != 0 && entityData.getIdOfPassport() != 0) {
            dbAccount.create(entityData);
        }
    }

    public EntityData[] list(){
        return dbAccount.list();
    }

    public void update(EntityData entityData){
        EntityData current = dbAccount.findByPasswordAndLogin(entityData.getLogin(), entityData.getPassword());
        if (current != null) {
            dbAccount.update(entityData);
        }
    }

    public void delete(String login, String password) {
        EntityData current = dbAccount.findByPasswordAndLogin(login, password);
        if (current != null ) {
            dbAccount.delete(login, password);
        }
    }

    public EntityData findByPasswordAndLogin(String login, String password){
        return dbAccount.findByPasswordAndLogin(login, password);
    }
    public void createCred(EntityGetCred entityGetCred, EntityData entityData, String login, String password) {
        EntityData current = dbAccount.findByPasswordAndLogin(login, password);
        if (current != null) {
            if (checkCreditOfData(entityGetCred, entityData)) {
                dbCredit.createCred(entityGetCred);
            }
        }
    }

    private boolean checkCreditOfData(EntityGetCred entityGetCred, EntityData entityData) {
        return entityGetCred.getFirstName().equals(entityData.getFirstName()) &&
                entityGetCred.getLastName().equals(entityData.getLastName()) &&
                entityGetCred.getSurName().equals(entityData.getSurName()) &&
                entityGetCred.getYearOfBirth() == entityData.getYearOfBirth() &&
                entityGetCred.getMonthOfBirth() == entityData.getMonthOfBirth() &&
                entityGetCred.getDayOfBirth() == entityData.getDayOfBirth() &&
                entityGetCred.getIdOfPassport() == entityData.getIdOfPassport();
    }
    public EntityGetCred[] listCred(){
        return dbCredit.listCred();
    }

    public void updatePassword(EntityData entityData){
        EntityData current = dbAccount.findByPasswordAndLogin(entityData.getLogin(), entityData.getPassword());
        if (current != null) {
            dbAccount.updatePassword(entityData);
        }
    }
}

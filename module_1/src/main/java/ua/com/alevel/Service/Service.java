package ua.com.alevel.Service;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.db.dbData;

public class Service {

    dbData dbData = new dbData();
    public void create(EntityData entityData) {
        if (entityData.getFirstName() != null && entityData.getLastName() != null && entityData.getSurName() != null
            && entityData.getDayOfBirth() != 0 && entityData.getMonthOfBirth() != 0 && entityData.getYearOfBirth() != 0 && entityData.getIdOfPassport() != 0) {
            dbData.create(entityData);
        }
    }

    public EntityData[] list(){
        return dbData.list();
    }

    public void update(EntityData entityData){
        EntityData current = dbData.findByPasswordAndLogin(entityData.getLogin(), entityData.getPassword());
        if (current != null) {
            dbData.update(entityData);
        }
    }

    public void delete(String login, String password) {
        EntityData current = dbData.findByPasswordAndLogin(login, password);
        if (current != null ) {
            dbData.delete(login, password);
        }
    }

    public EntityData findByPasswordAndLogin(String login, String password){
        return dbData.findByPasswordAndLogin(login, password);
    }
    public void createCred(EntityGetCred entityGetCred, EntityData entityData, String login, String password) {
        EntityData current = dbData.findByPasswordAndLogin(login, password);
        if (current != null) {
            if (checkData(entityGetCred, entityData)) {
                dbData.createCred(entityGetCred);
            }
        }
    }

    private boolean checkData(EntityGetCred entityGetCred, EntityData entityData) {
        return entityGetCred.getFirstName().equals(entityData.getFirstName()) &&
                entityGetCred.getLastName().equals(entityData.getLastName()) &&
                entityGetCred.getSurName().equals(entityData.getSurName()) &&
                entityGetCred.getYearOfBirth() == entityData.getYearOfBirth() &&
                entityGetCred.getMonthOfBirth() == entityData.getMonthOfBirth() &&
                entityGetCred.getDayOfBirth() == entityData.getDayOfBirth() &&
                entityGetCred.getIdOfPassport() == entityData.getIdOfPassport();
    }
    public EntityGetCred[] listCred(){
        return dbData.listCred();
    }
}

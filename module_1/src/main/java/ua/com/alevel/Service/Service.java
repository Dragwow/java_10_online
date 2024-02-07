package ua.com.alevel.Service;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.Entity.PlasticCard;
import ua.com.alevel.db.dbAccount;


public class Service {

    dbAccount dbAccount = new dbAccount();

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
                dbAccount.createCred(entityGetCred);
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
        return dbAccount.listCred();
    }

    public void updatePassword(EntityData entityData){
        EntityData current = dbAccount.findByPasswordAndLogin(entityData.getLogin(), entityData.getPassword());
        if (current != null) {
            dbAccount.updatePassword(entityData);
        }
    }

    public EntityData[] findByData(EntityData entityData, String firstName, String lastName, String surName) {
        if (entityData.getFirstName() != null &&
                entityData.getLastName() != null &&
                entityData.getSurName() != null &&
                entityData.getDayOfBirth() != 0 &&
                entityData.getMonthOfBirth() != 0 &&
                entityData.getYearOfBirth() != 0) {

            EntityData[] byDateResult = dbAccount.findByDate(entityData);
            EntityData[] byNamesResult = new EntityData[]{dbAccount.findByNames(
                    firstName,
                    lastName,
                    surName)};

            int totalLength = byDateResult.length + byNamesResult.length;

            EntityData[] combinedResult = new EntityData[totalLength];

            for (int i = 0; i < byDateResult.length; i++) {
                combinedResult[i] = byDateResult[i];
            }

            for (int i = 0; i < byNamesResult.length; i++) {
                combinedResult[byDateResult.length + i] = byNamesResult[i];
            }

            int distinctCount = 0;
            for (int i = 0; i < totalLength; i++) {
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (combinedResult[i] != null && combinedResult[j] != null &&
                            combinedResult[i].equals(combinedResult[j])) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    distinctCount++;
                }
            }

            EntityData[] distinctResult = new EntityData[distinctCount];

            int currentIndex = 0;
            for (int i = 0; i < totalLength; i++) {
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (combinedResult[i] != null && combinedResult[j] != null &&
                            combinedResult[i].equals(combinedResult[j])) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    distinctResult[currentIndex] = combinedResult[i];
                    currentIndex++;
                }
            }

            return distinctResult;
        }

        return null;
    }

    public EntityData[] findByPassport(int passportId){
        return new EntityData[]{dbAccount.findByPassport(passportId)};
    }

    public void createPlasticCard(PlasticCard plasticCard) {
        if (plasticCard.getFirstName() != null && plasticCard.getLastName() != null) {
            dbAccount.createPlasticCard(plasticCard);
        }
    }

    public PlasticCard[] listPlastic(){
        return dbAccount.listPlastic();
    }
}

package ua.com.alevel.db;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.Entity.PlasticCard;

public class dbAccount {

    private EntityData[] entityDats = new EntityData[10];
    private EntityGetCred[] entityGetCredits = new EntityGetCred[10];
    private PlasticCard[] plasticCards = new PlasticCard[10];

    public void create(EntityData entityData) {
        int index = -1;
        for (int i = 0; i < entityDats.length; i++) {
            if (entityDats[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            EntityData[] newEntityData = new EntityData[entityDats.length + 10];
            System.arraycopy(entityDats, 0, newEntityData, 0, entityDats.length);
            entityDats = newEntityData;
            index = entityDats.length - 1;
        }
        entityDats[index] = entityData;
    }
    public EntityData[] list(){
        return entityDats;
    }

    public void update(EntityData entityData){
        for (int i = 0; i < entityDats.length; i++) {
            if (entityDats[i] != null) {
                entityDats[i] = entityData;
                break;
            }
        }

    }

    public void delete(String findLogin, String findPassword) {
        for (int i = 0; i < entityDats.length; i++) {
            if (entityDats[i] != null && entityDats[i].getLogin().equals(findLogin) && entityDats[i].getPassword().equals(findPassword)) {
                entityDats[i] = null;
            }
        }
    }

    public EntityData findByPasswordAndLogin(String login, String password){
        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getLogin().equals(login)){
                return entityData;
            }
        }
        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getPassword().equals(password)){
                return entityData;
            }
        }
        return null;
    }

    public void updatePassword(EntityData entityData){
        for (int i = 0; i < entityDats.length; i++) {
            if (entityDats[i] != null) {
                entityDats[i] = entityData;
                break;
            }
        }
    }
    public void createCred(EntityGetCred entityGetCred) {
        for (int i = 0; i < entityGetCredits.length; i++) {
            if (entityGetCredits[i] == null) {
                entityGetCredits[i] = entityGetCred;
                return;
            }
        }
        EntityGetCred[] newEntityGetCredits = new EntityGetCred[entityGetCredits.length + 10];
        System.arraycopy(entityGetCredits, 0, newEntityGetCredits, 0, entityGetCredits.length);
        newEntityGetCredits[entityGetCredits.length] = entityGetCred;
        entityGetCredits = newEntityGetCredits;
    }
    public EntityGetCred[] listCred(){
        return entityGetCredits;
    }

    public EntityData[] findByDate(EntityData entityData) {
        int num = 0;

        for (EntityData currentData : entityDats) {
            if (currentData != null &&
                    currentData.getDayOfBirth() != 0 &&
                    currentData.getMonthOfBirth() != 0 &&
                    currentData.getYearOfBirth() != 0 &&
                    currentData.getDayOfBirth() == entityData.getDayOfBirth() &&
                    currentData.getMonthOfBirth() == entityData.getMonthOfBirth() &&
                    currentData.getYearOfBirth() == entityData.getYearOfBirth()) {

                num++;
            }
        }

        EntityData[] foundData = new EntityData[num];
        int index = 0;

        for (EntityData currentData : entityDats) {
            if (currentData != null &&
                    currentData.getDayOfBirth() != 0 &&
                    currentData.getMonthOfBirth() != 0 &&
                    currentData.getYearOfBirth() != 0 &&
                    currentData.getDayOfBirth() == entityData.getDayOfBirth() &&
                    currentData.getMonthOfBirth() == entityData.getMonthOfBirth() &&
                    currentData.getYearOfBirth() == entityData.getYearOfBirth()) {

                foundData[index++] = currentData;
            }
        }
        return foundData;
    }

    public EntityData findByPassport(int passportId){
        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getIdOfPassport() == passportId){
                return entityData;
            }
        }
        return null;
    }

    public EntityData findByNames(String firstName, String lastName, String surName) {
        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getFirstName().equals(firstName)){
                return entityData;
            }
        }

        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getLastName().equals(lastName)){
                return entityData;
            }
        }

        for (EntityData entityData : entityDats){
            if (entityData != null && entityData.getSurName().equals(surName)){
                return entityData;
            }
        }
        return null;
    }

    public void createPlasticCard(PlasticCard plasticCard){
        int index = -1;
        for (int i = 0; i < plasticCards.length; i++) {
            if (plasticCards[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            PlasticCard[] newPlasticCard = new PlasticCard[plasticCards.length + 10];
            System.arraycopy(plasticCards, 0, newPlasticCard, 0, plasticCards.length);
            plasticCards = newPlasticCard;
            index = plasticCards.length - 1;
        }
        plasticCards[index] = plasticCard;
    }

    public PlasticCard[] listPlastic(){
        return plasticCards;
    }


}

package ua.com.alevel.db;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;

public class dbData {

    private EntityData[] entityDats = new EntityData[10];
    private EntityGetCred[] entityGetCredits = new EntityGetCred[10];

    public void create(EntityData entityData) {
        int index = -1;
        for (int i = 0; i < entityDats.length; i++) {
            if (entityDats[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            EntityData[] newEntityData = new EntityData[entityDats.length + 1];
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

    public void createCred(EntityGetCred entityGetCred) {
        for (int i = 0; i < entityGetCredits.length; i++) {
            if (entityGetCredits[i] == null) {
                entityGetCredits[i] = entityGetCred;
                return;
            }
        }

        // Если все элементы заняты, увеличиваем массив
        EntityGetCred[] newEntityGetCredits = new EntityGetCred[entityGetCredits.length * 2];
        System.arraycopy(entityGetCredits, 0, newEntityGetCredits, 0, entityGetCredits.length);
        newEntityGetCredits[entityGetCredits.length] = entityGetCred;
        entityGetCredits = newEntityGetCredits;
    }
    public EntityGetCred[] listCred(){
        return entityGetCredits;
    }
}





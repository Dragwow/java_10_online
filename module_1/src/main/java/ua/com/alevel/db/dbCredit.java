package ua.com.alevel.db;

import ua.com.alevel.Entity.EntityGetCred;

public class dbCredit {

    private EntityGetCred[] entityGetCredits = new EntityGetCred[10];


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
}

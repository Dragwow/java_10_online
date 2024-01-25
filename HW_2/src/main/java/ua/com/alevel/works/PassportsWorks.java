package ua.com.alevel.works;

import ua.com.alevel.entity.LostPassport;
import ua.com.alevel.entity.Passport;

public class PassportsWorks {

    private final Passport[] passports = new Passport[20];
    private final LostPassport[] lostPassports = new LostPassport[20];


    public void create(Passport passport) {
        for (int i = 0; i < passports.length; i++) {
            if (passports[i] == null) {
                passports[i] = passport;
                passport.setId(i);
                break;
            }
        }
    }

    public void update(Passport passport) {
        for (int i = 0; i < passports.length; i++) {
            if (passports[i] != null) {
                passports[i] = passport;
                break;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < passports.length; i++) {
            if (passports[i] != null && passports[i].getId() == id) {
                passports[i] = null;
            }
        }
    }

    public Passport[] findAll() {
        return passports;
    }

    public Passport findById(int id) {
        for (Passport passport : passports) {
            if (passport != null && passport.getId() == id) {
                return passport;
            }
        }
        return null;
    }

    public Passport[] findByFio(Passport passport) {
        int num = 0;

        for (Passport currentPassport : passports) {
            if (currentPassport != null &&
                    currentPassport.getFirstName() != null &&
                    currentPassport.getLastName() != null &&
                    currentPassport.getFatherName() != null &&
                    currentPassport.getFirstName().equals(passport.getFirstName()) &&
                    currentPassport.getLastName().equals(passport.getLastName()) &&
                    currentPassport.getFatherName().equals(passport.getFatherName())) {

                num++;
            }
        }

        Passport[] foundPassports = new Passport[num];
        int index = 0;

        for (Passport currentPassport : passports) {
            if (currentPassport != null &&
                    currentPassport.getFirstName() != null &&
                    currentPassport.getLastName() != null &&
                    currentPassport.getFatherName() != null &&
                    currentPassport.getFirstName().equals(passport.getFirstName()) &&
                    currentPassport.getLastName().equals(passport.getLastName()) &&
                    currentPassport.getFatherName().equals(passport.getFatherName())) {

                foundPassports[index++] = currentPassport;
            }
        }
        return foundPassports;
    }

    public void updateToLost(LostPassport lostPassport) {
        for (int i = 0; i < lostPassports.length; i++) {
            if (lostPassports[i] == null ) {
                lostPassports[i] = lostPassport;
                lostPassport.setLostId(i);
                break;
            }
        }
    }

    public void lostDelete(int id) {
        for (int i = 0; i < lostPassports.length; i++) {
            if (lostPassports[i] != null && lostPassports[i].getLostId() == id) {
                lostPassports[i] = null;
            }
        }
    }

    public LostPassport[] lostFindAll() {
        return lostPassports;
    }

    public LostPassport findByLostId(int id) {
        for (LostPassport lostPassport : lostPassports) {
            if (lostPassport != null && lostPassport.getLostId() == id) {
                return lostPassport;
            }
        }
        return null;
    }
}

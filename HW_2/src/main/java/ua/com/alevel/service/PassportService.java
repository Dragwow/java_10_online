package ua.com.alevel.service;


import ua.com.alevel.entity.LostPassport;
import ua.com.alevel.entity.Passport;
import ua.com.alevel.works.PassportsWorks;

import java.util.Arrays;

public class PassportService {

    private final PassportsWorks passportsWorks =new PassportsWorks();

    public void create(Passport passport) {
        if (passport.getFirstName() != null && passport.getLastName() != null && passport.getFatherName() != null && passport.getAge() > 0) {
            passportsWorks.create(passport);
        }
    }

    public void update(Passport passport) {
        Passport current = passportsWorks.findById(passport.getId());
        if (current != null) {
            passportsWorks.update(passport);
        }
    }

    public void delete(int id) {
        Passport current = passportsWorks.findById(id);
        if (current != null ) {
            passportsWorks.delete(id);
        }
    }

    public Passport[] findAll() {
        return passportsWorks.findAll();
    }
    public Passport[] findByFio(Passport passport) {
        if (passport.getFirstName() != null && passport.getLastName() != null && passport.getFatherName() != null) {
            return passportsWorks.findByFio(passport);
        }

        return null;
    }

    public Passport findById(int id) {
        return passportsWorks.findById(id);
    }
    public void updateToLost(LostPassport lostPassport) {
        if (lostPassport.getLostFirstName() != null && lostPassport.getLostLastName() != null && lostPassport.getLostFatherName() != null && lostPassport.getLostAge() > 0) {
            passportsWorks.updateToLost(lostPassport);
        }
    }

    public LostPassport[] lostFindAll() {
        return passportsWorks.lostFindAll();
    }

    public void lostDelete(int id) {
        LostPassport current = passportsWorks.findByLostId(id);
        if (current != null) {
            passportsWorks.lostDelete(id);
        }
    }

    public LostPassport findByLostId(int id) {
        return passportsWorks.findByLostId(id);
    }
}
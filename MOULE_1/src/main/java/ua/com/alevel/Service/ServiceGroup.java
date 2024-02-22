package ua.com.alevel.Service;

import ua.com.alevel.Entity.AccountGroup;
import ua.com.alevel.Entity.Group;
import ua.com.alevel.db.AccountGroupRelation;

public class ServiceGroup {
    private final AccountGroupRelation db = AccountGroupRelation.getInstance();

    public void createGroup(Group group) {
        db.createGroup(group);
    }

    public void attachStudentForGroup(String studentId, String groupId) {
        db.attachAccountToGroup(studentId, groupId);
    }

    public Group[] showGroup(){
        return db.showGroup();
    }

    public Group[] findByGroup(String rehabilitation){
        return db.findByGroup(rehabilitation);
    }

    public AccountGroup[] showAccountGroup() {
        return db.showAccountGroup();
    }


}

package ua.com.alevel.hw_7.db;



import ua.com.alevel.hw_7.entity.Account;
import ua.com.alevel.hw_7.entity.Group;


import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DBResource {

    List<Group> groupList = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();


    private  static final DBResource instance = new DBResource();

    private DBResource(){}


    public static DBResource getInstance(){
        return instance;
    }

    public void createAcc(Account account){
        account.setId(UUID.randomUUID().toString());
        accountList.add(account);
    }

    public void createGroup(Group group){
        group.setId(UUID.randomUUID().toString());
        groupList.add(group);
    }

    public void updateAcc(Account account){
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId().equals(account.getId())) {
                accountList.set(i, account);
                break;
            }
        }
    }

    public void updateGroup(Group group){
        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).getId().equals(group.getId())) {
                groupList.set(i, group);
                break;
            }
        }
    }

    public void deleteAcc(String id){
        accountList.removeIf(account -> account.getId().equals(id));
    }

    public void deleteGroup(String id){
        groupList.removeIf(group -> group.getId().equals(id));
    }

    public Account findAccById(String id){
        return accountList.stream().filter(account -> account.getId().equals(id)).findFirst().get();
    }

    public Group findGroupById(String id){
        return groupList.stream().filter(group -> group.getId().equals(id)).findFirst().get();
    }

    public Collection<Account> findAllAcc(){
        return accountList;
    }

    public Collection<Group> findAllGroup(){
        return groupList;
    }


}

package ua.com.alevel.db;

import ua.com.alevel.Entity.Account;
import ua.com.alevel.Entity.AccountGroup;
import ua.com.alevel.Entity.Group;

import java.util.UUID;

public class AccountGroupRelation {

    private Account[] accounts = new Account[10];
    private Group[] groups = new Group[10];
    private AccountGroup[] accountGroups= new AccountGroup[3];
    private static AccountGroupRelation instance;

    private int index;

    public static AccountGroupRelation getInstance() {
        if (instance == null) {
            instance = new AccountGroupRelation();
        }
        return instance;
    }

    public void create(Account account) {
        index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                index = i;

                break;
            }
        }
        if (index == -1) {
            Account[] newAccount = new Account[accounts.length + 10];
            System.arraycopy(accounts, 0, newAccount, 0, accounts.length);
            accounts = newAccount;
            index = accounts.length - 1;
        }
        accounts[index] = account;
        account.setId(generateIDForAccount());
    }

    public Account[] showAll(){
        return accounts;
    }

    public Account findByPasswordAndLogin(String login, String password){
        for (Account account : accounts){
            if (account != null && account.getLogin().equals(login)){
                return account;
            }
        }
        for (Account account : accounts){
            if (account != null && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }

    public void update(Account account){
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                accounts[i] = account;
                break;
            }
        }
    }

    public void delete(String findLogin, String findPassword) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getLogin().equals(findLogin) && accounts[i].getPassword().equals(findPassword)) {
                accounts[i] = null;
            }
        }
    }

    public void createGroup(Group group) {
        index = -1;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Group[] newGroup = new Group[groups.length + 10];
            System.arraycopy(groups, 0, newGroup, 0, groups.length);
            groups = newGroup ;
            index = groups.length - 1;
        }
        groups[index] = group;
        group.setId(generateIDForGroup());
    }

    public String generateIDForAccount(){
        String id = UUID.randomUUID().toString();
        for (Account account : accounts) {
            if (account != null && id.equals(account.getId())) {
                return generateIDForAccount();
            }
        }
        return id;
    }

    public String generateIDForGroup(){
        String id = UUID.randomUUID().toString();
        for (Group group : groups) {
            if (group != null && id.equals(group.getId())) {
                return generateIDForAccount();
            }
        }
        return id;
    }

    public void attachAccountToGroup(String accountId, String groupId){
        if (accountGroups[accountGroups.length - 1] == null) {
            AccountGroup[] newAccountGroup = new AccountGroup[accountGroups.length + 10];
            System.arraycopy(accountGroups, 0, newAccountGroup, 0, accountGroups.length);
            accountGroups = newAccountGroup;
        }
        for (AccountGroup accountGroup : accountGroups) {
            if (accountGroup != null && accountGroup.getAccountId().equals(accountId) && accountGroup.getGroupId().equals(groupId)){
                return;
            }
        }
        AccountGroup accountGroup = new AccountGroup();
        accountGroup.setAccountId(accountId);
        accountGroup.setGroupId(groupId);
        for (int i = 0; i < accountGroups.length; i++) {
            if (accountGroups[i] == null) {
                accountGroups[i] = accountGroup;
                break;
            }
        }
    }

    public Group[] showGroup(){
        return groups;
    }

    public Group[] findByGroup(String rehabilitation) {
        for (Group group : groups){
            if (group != null && group.getName().equals(rehabilitation)){
                return groups;
            }
        }
        return null;
    }
    public Account findAccountById(String id) {
        for (Account account : accounts) {
            if (account != null && account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public AccountGroup[] showAccountGroup(){
        return accountGroups;
    }



}

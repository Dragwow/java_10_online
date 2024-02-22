package ua.com.alevel.Work;

import ua.com.alevel.Entity.Account;
import ua.com.alevel.Entity.AccountGroup;
import ua.com.alevel.Entity.Group;
import ua.com.alevel.Service.ServiceAccount;
import ua.com.alevel.Service.ServiceGroup;
import ua.com.alevel.console.AccountConsole;
import ua.com.alevel.console.AdminConsole;

import java.io.BufferedReader;
import java.io.IOException;

public class WorkAcc {

    private static final ServiceAccount serviceA = new ServiceAccount();
    private static final ServiceGroup serviceG = new ServiceGroup();

    private static String login;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String surName;
    private static int age;

    private static void find(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.print("Enter login: ");
        login = reader.readLine();
        System.out.print("Enter password: ");
        password = reader.readLine();
    }

    private static void data(BufferedReader reader) throws IOException{
        System.out.print("Enter your firstname: ");
        firstName = reader.readLine();
        System.out.print("Enter your lastname: ");
        lastName = reader.readLine();
        System.out.print("Enter your surname: ");
        surName = reader.readLine();
        System.out.print("Enter your age: ");
        age = Integer.parseInt(reader.readLine());
    }

    public static void create(BufferedReader reader) throws IOException{
        find(reader);
        data(reader);
        Account account = new Account();
        account.setLogin(login);
        account.setPassword(password);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setSurName(surName);
        account.setAge(age);
        serviceA.create(account);
    }

    public static void showAll(){
        Account[] accounts = serviceA.showAll();
        for (Account account : accounts) {
            if (account != null) {
                System.out.println();
                System.out.println("Login : " + account.getLogin() +
                        " | Full name : " + account.getFirstName() + " " + account.getLastName() + " " + account.getSurName() +
                        " | Age : " + account.getAge() +
                        " | ID : " + account.getId());
            }
        }
    }

    public static void showInfo(BufferedReader reader) throws IOException {
        find(reader);
        Account account = serviceA.findByPasswordAndLogin(login, password);
        if (account != null){
            System.out.println();
            System.out.println(" | Login : " + account.getLogin());
            System.out.println(" | Full name : " + account.getFirstName() + " " + account.getLastName() + " " + account.getSurName());
            System.out.println(" | Age : " + account.getAge());
            System.out.println(" | ID : " + account.getId());
        }
    }

    public static void showGroupsInfo(){
        Group[] groups = serviceG.showGroup();
        for (Group group : groups) {
            if (group != null) {
                System.out.println();
                System.out.println("Name group : " + group.getName() + " ID group: " + group.getId());
            }
        }
    }

    public static void logInAdmin(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("     Log in admin   ");
        find(reader);
        if (login.equals("admin") && password.equals("admin")){
            new AdminConsole().start();
        }else {
            System.out.println();
            System.out.println("No access");
        }
    }

    public static void logInStart(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("     Log in    ");
        find(reader);
        Account loginAccount = serviceA.findByPasswordAndLogin(login, password);
        if (loginAccount != null){
            new AccountConsole().start();
        }else {
            System.out.println();
            System.out.println("Try again or register");
        }
    }

    public static void update(BufferedReader reader) throws IOException {
        find(reader);
        Account account = serviceA.findByPasswordAndLogin(login, password);
        if (account != null) {
            data(reader);
            account.setLogin(login);
            account.setPassword(password);
            account.setFirstName(firstName);
            account.setLastName(lastName);
            account.setSurName(surName);
            account.setAge(age);
            serviceA.update(account);
        }
    }

    public static void reset(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("If you want to change your password, enter yes or the opposite then no.");
        String word = reader.readLine();
        if (word.equals("yes")) {
            find(reader);
            Account UpdatePassword = serviceA.findByPasswordAndLogin(login, password);
            while (true) {
                if (UpdatePassword != null) {
                    System.out.println();
                    System.out.print("Enter new password: ");
                    String newPassword = reader.readLine();
                    System.out.println();
                    System.out.print("Enter again new password: ");
                    String newPassword2 = reader.readLine();
                    if (newPassword.equals(newPassword2)) {
                        UpdatePassword.setPassword(newPassword);
                        serviceA.reset(UpdatePassword);
                        break;
                    } else {
                        System.out.println();
                        System.out.print("Try again.");
                    }
                }
            }
        }
    }

    public static void delete(BufferedReader reader) throws IOException {
        find(reader);
        Account account = serviceA.findByPasswordAndLogin(login, password);
        if (account != null){
            serviceA.delete(login, password);
            System.out.println();
            System.out.println("Account was deleted.");
        }else {
            System.out.println();
            System.out.println("Not found account or enter again.");
        }
    }

    public static void addGroup(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("If you want to rehabilitation:");
        System.out.println("1.Addiction;");
        System.out.println("2.Smoking;");
        System.out.println("3.Alcoholism;");
        System.out.print("Enter: ");
        String num = reader.readLine();
        switch (num){
            case "1"->{
                find(reader);
                Account account = serviceA.findByPasswordAndLogin(login, password);
                if (account != null){
                    Group group = new Group();
                    group.setName("Addiction");
                    serviceG.createGroup(group);
                    System.out.print("Enter your ID: ");
                    String accountId = reader.readLine();
                    serviceG.attachStudentForGroup(accountId, group.getId());
                }else System.out.println("Not found account.");
            }
            case "2"->{
                find(reader);
                Account account = serviceA.findByPasswordAndLogin(login, password);
                if (account != null){
                    Group group = new Group();
                    group.setName("Smoking");
                    serviceG.createGroup(group);
                    System.out.print("Enter your ID: ");
                    String accountId = reader.readLine();
                    serviceG.attachStudentForGroup(accountId, group.getId());
                }else System.out.println("Not found account.");
            }
            case "3"->{
                find(reader);
                Account account = serviceA.findByPasswordAndLogin(login, password);
                if (account != null){
                    Group group = new Group();
                    group.setName("Alcoholism");
                    serviceG.createGroup(group);
                    System.out.print("Enter your ID: ");
                    String accountId = reader.readLine();
                    serviceG.attachStudentForGroup(accountId, group.getId());
                }else System.out.println("Not found account.");
            }
        }
    }

    public static void showGroups(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("Show rehabilitation:");
        System.out.println("1.Addiction;");
        System.out.println("2.Smoking;");
        System.out.println("3.Alcoholism;");
        String num = reader.readLine();
        switch (num){
            case "1"->{
                System.out.println("    Addiction  ");
                System.out.println();
                String rehabilitation = "Addiction";
                Group[] groups = serviceG.findByGroup(rehabilitation);
                for (Group group : groups) {
                    if (group != null) {
                        System.out.println(" | ID groups : " + group.getId());
                    }
                }
            }
            case "2"->{
                System.out.println("    Smoking  ");
                System.out.println();
                String rehabilitation = "Smoking";
                Group[] groups = serviceG.findByGroup(rehabilitation);
                for (Group group : groups) {
                    if (group != null) {
                        System.out.println(" | ID groups : " + group.getId());
                    }
                }
            }
            case "3"->{
                System.out.println("    Alcoholism  ");
                System.out.println();
                String rehabilitation = "Alcoholism";
                Group[] groups = serviceG.findByGroup(rehabilitation);
                for (Group group : groups) {
                    if (group != null) {
                        System.out.println(" | ID groups : " + group.getId());
                    }
                }
            }
        }
    }

    public static void findAccountById(BufferedReader reader) throws IOException{
        System.out.print("Enter ID account: ");
        String id = reader.readLine();
        Account account = serviceA.findAccountById(id);
        if (account != null){
            System.out.println();
            System.out.println(" | Login : " + account.getLogin());
            System.out.println(" | Full name : " + account.getFirstName() + " " + account.getLastName() + " " + account.getSurName());
            System.out.println(" | Age : " + account.getAge());
            System.out.println(" | ID : " + account.getId());
        }
    }

    public static void showAccountGroup(){
        AccountGroup[] accountGroups = serviceG.showAccountGroup();
        for (AccountGroup accountGroup : accountGroups){
            if (accountGroup != null) {
                System.out.println();
                System.out.println(" | ID account : " + accountGroup.getAccountId() +
                        " | ID group : " + accountGroup.getGroupId());
            }
        }
    }

}

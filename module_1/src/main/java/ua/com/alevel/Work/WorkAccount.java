package ua.com.alevel.Work;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.Entity.PlasticCard;
import ua.com.alevel.Service.Service;
import ua.com.alevel.console.Account;
import ua.com.alevel.console.AdminProfile;
import ua.com.alevel.console.DebitCard;


import java.io.BufferedReader;
import java.io.IOException;

public class WorkAccount {

    private static final Service service = new Service();

    public static void create(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.print("Enter login: ");
        String login = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();
        System.out.print("Enter firstname: ");
        String firstName = reader.readLine();
        System.out.print("Enter lastname: ");
        String lastName = reader.readLine();
        System.out.print("Enter surname: ");
        String surName = reader.readLine();
        System.out.print("Enter year of birth: ");
        int yearOfBirth = Integer.parseInt(reader.readLine());
        System.out.print("Enter month of birth: ");
        int monthOfBirth = Integer.parseInt(reader.readLine());
        System.out.print("Enter day of birth: ");
        int dayOfBirth = Integer.parseInt(reader.readLine());
        System.out.print("Enter id of passport: ");
        int idOfPassport = Integer.parseInt(reader.readLine());
        EntityData entityData = new EntityData();
        entityData.setLogin(login);
        entityData.setPassword(password);
        entityData.setFirstName(firstName);
        entityData.setLastName(lastName);
        entityData.setSurName(surName);
        entityData.setYearOfBirth(yearOfBirth);
        entityData.setMonthOfBirth(monthOfBirth);
        entityData.setDayOfBirth(dayOfBirth);
        entityData.setIdOfPassport(idOfPassport);
        service.create(entityData);

    }
    public static void list()  {
        EntityData[] entityDats = service.list();

        if (entityDats.length != 0) {
            for (EntityData entityDat : entityDats) {
                if (entityDat != null) {
                    System.out.println();
                    System.out.println("Login: " + entityDat.getLogin() +
                            " | FLS: " + entityDat.getFirstName() + " " + entityDat.getLastName() + " " + entityDat.getSurName() +
                            " | Date of birth : " + entityDat.getDayOfBirth() + "/" + entityDat.getMonthOfBirth() + "/" + entityDat.getYearOfBirth() +
                            " | Id of passport: " + entityDat.getIdOfPassport());
                }
            }
        } else {
            System.out.println("Not found accounts!");
        }
    }

    public static void update(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        EntityData entityDataToUpdate = service.findByPasswordAndLogin(findLogin, findPassword);
        if (entityDataToUpdate != null) {
            System.out.print("Enter firstname: ");
            String firstName = reader.readLine();
            System.out.print("Enter lastname: ");
            String lastName = reader.readLine();
            System.out.print("Enter surname: ");
            String surName = reader.readLine();
            System.out.print("Enter year of birth: ");
            int yearOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter month of birth: ");
            int monthOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter day of birth: ");
            int dayOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter id of passport: ");
            int idOfPassport = Integer.parseInt(reader.readLine());
            entityDataToUpdate.setLogin(findLogin);
            entityDataToUpdate.setPassword(findPassword);
            entityDataToUpdate.setFirstName(firstName);
            entityDataToUpdate.setLastName(lastName);
            entityDataToUpdate.setSurName(surName);
            entityDataToUpdate.setYearOfBirth(yearOfBirth);
            entityDataToUpdate.setMonthOfBirth(monthOfBirth);
            entityDataToUpdate.setDayOfBirth(dayOfBirth);
            entityDataToUpdate.setIdOfPassport(idOfPassport);
            service.update(entityDataToUpdate);
        }
    }

    public static void delete(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        EntityData entityDataDelete = service.findByPasswordAndLogin(findLogin, findPassword);
        if (entityDataDelete != null){
            service.delete(findLogin, findPassword);
            System.out.println();
            System.out.println("Account was deleted.");
        }else {
            System.out.println();
            System.out.println("Not found account or enter again.");
        }
    }

    public static void updatePassword(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("If you want to change your password, enter yes or the opposite then no.");
        String word = reader.readLine();
        if (word.equals("yes")) {
            System.out.println();
            System.out.print("Enter Login: ");
            String findLogin = reader.readLine();
            System.out.print("Enter password: ");
            String findPassword = reader.readLine();
            EntityData entityDataUpdatePassword = service.findByPasswordAndLogin(findLogin, findPassword);
            while (true) {
                if (entityDataUpdatePassword != null) {
                    System.out.println();
                    System.out.print("Enter new password: ");
                    String newPassword = reader.readLine();
                    System.out.println();
                    System.out.print("Enter again new password: ");
                    String newPassword2 = reader.readLine();
                    if (newPassword.equals(newPassword2)) {
                        entityDataUpdatePassword.setPassword(newPassword);
                        service.updatePassword(entityDataUpdatePassword);
                        break;
                    } else {
                        System.out.println();
                        System.out.print("Try again.");
                    }
                }
            }
        }
    }

    public static void logInStart(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("     Log in    ");
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        EntityData loginAccount = service.findByPasswordAndLogin(findLogin, findPassword);
        if (loginAccount != null){
            Account account = new Account();
            account.start();
        }else {
            System.out.println();
            System.out.println("Try again or register");
        }
    }

    public static void logInAdmin(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("     Log in admin   ");
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        if (findLogin.equals("admin") && findPassword.equals("admin")){
            AdminProfile adminProfile = new AdminProfile();
            adminProfile.start();
        }else {
            System.out.println();
            System.out.println("No access");
        }
    }

    public static void logInCard(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("     Log in    ");
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        EntityData loginAccount = service.findByPasswordAndLogin(findLogin, findPassword);
        if (loginAccount != null){
            DebitCard debitCard = new DebitCard();
            debitCard.start();
        }else {
            System.out.println();
            System.out.println("Try again or register");
        }
    }

    public static void createCred(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.print("Enter Login: ");
        String findLogin = reader.readLine();
        System.out.print("Enter password: ");
        String findPassword = reader.readLine();
        EntityData entityData = service.findByPasswordAndLogin(findLogin, findPassword);
        if (entityData != null) {
            System.out.print("Enter firstname: ");
            String firstName = reader.readLine();
            System.out.print("Enter lastname: ");
            String lastName = reader.readLine();
            System.out.print("Enter surname: ");
            String surName = reader.readLine();
            System.out.print("Enter year of birth: ");
            int yearOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter month of birth: ");
            int monthOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter day of birth: ");
            int dayOfBirth = Integer.parseInt(reader.readLine());
            System.out.print("Enter id of passport: ");
            int idOfPassport = Integer.parseInt(reader.readLine());
            System.out.print("Enter amount of credit (1000-1000000): ");
            int sumOfCredit = Integer.parseInt(reader.readLine());
            EntityGetCred entityGetCred = new EntityGetCred();
            entityGetCred.setLogin(findLogin);
            entityGetCred.setFirstName(firstName);
            entityGetCred.setLastName(lastName);
            entityGetCred.setSurName(surName);
            entityGetCred.setYearOfBirth(yearOfBirth);
            entityGetCred.setMonthOfBirth(monthOfBirth);
            entityGetCred.setDayOfBirth(dayOfBirth);
            entityGetCred.setIdOfPassport(idOfPassport);
            entityGetCred.setSumOfCredit(sumOfCredit);
            service.createCred(entityGetCred,entityData, findLogin , findPassword);
        }

    }

    public static void listCred()  {
        EntityGetCred[] entityGetCredits = service.listCred();
        if (entityGetCredits.length != 0) {
            for (EntityGetCred entityGetCred : entityGetCredits) {
                if (entityGetCred != null) {
                    System.out.println();
                    System.out.println("Login: " + entityGetCred.getLogin() +
                            " | FLS: " + entityGetCred.getFirstName() + " " + entityGetCred.getLastName() + " " + entityGetCred.getSurName() +
                            " | Date of birth : " + entityGetCred.getDayOfBirth() + "/" + entityGetCred.getMonthOfBirth() + "/" + entityGetCred.getYearOfBirth() +
                            " | Id of passport: " + entityGetCred.getIdOfPassport() + " " +
                            " | Credit: " + entityGetCred.getSumOfCredit());
                }
            }
        } else {
            System.out.println("Not found accounts!");
        }
    }

    public static void plasticCard(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.print("Enter firstname: ");
        String firstName = reader.readLine();
        System.out.print("Enter lastname: ");
        String lastName = reader.readLine();
        System.out.print("Enter surname: ");
        String surName = reader.readLine();
        System.out.print("Please enter date of birth (dd mm yyyy): ");
        String date = reader.readLine();

        EntityData dateToSearch = new EntityData();
        String[] dateParts = date.split(" ");
        if (dateParts.length >= 1) {
            dateToSearch.setDayOfBirth(Integer.parseInt(dateParts[0]));
        }
        if (dateParts.length >= 2) {
            dateToSearch.setMonthOfBirth(Integer.parseInt(dateParts[1]));
        }
        if (dateParts.length >= 3) {
            dateToSearch.setYearOfBirth(Integer.parseInt(dateParts[2]));
        }

        EntityData[] entityData = service.findByData(dateToSearch, firstName, lastName, surName);
        System.out.print("Enter passport id: ");
        int passportId = Integer.parseInt(reader.readLine());
        entityData = service.findByPassport(passportId);
        System.out.print("Data verification completed");
        System.out.println();
        System.out.print("Enter card name: ");
        String cardName = reader.readLine();
        PlasticCard plasticCard = new PlasticCard();
        plasticCard.setFirstName(firstName);
        plasticCard.setLastName(lastName);
        plasticCard.setPlasticCard(cardName);
        service.createPlasticCard(plasticCard);
    }

    public static void listPlastic(){
        PlasticCard[] plasticCards = service.listPlastic();
        if (plasticCards.length != 0) {
            for (PlasticCard plasticCard : plasticCards) {
                if (plasticCard != null) {
                    System.out.println();
                    System.out.println("Name of card: " + plasticCard.getPlasticCard() +
                            " | FLS: " + plasticCard.getFirstName() + " " + plasticCard.getLastName());
                }
            }
        } else {
            System.out.println("Not found accounts!");
        }
    }


}

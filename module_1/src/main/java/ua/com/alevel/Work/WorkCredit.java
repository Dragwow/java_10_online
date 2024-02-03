package ua.com.alevel.Work;

import ua.com.alevel.Service.Service;
import ua.com.alevel.Entity.EntityGetCred;
import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Entity.DebitCardAccount;

import java.io.BufferedReader;
import java.io.IOException;

public class WorkCredit {

    private static final Service service = new Service();

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
            System.out.print("Enter value of credit(max 1000000): ");
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
}

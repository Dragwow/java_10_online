package ua.com.alevel.Work;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Service.Service;

import java.io.BufferedReader;
import java.io.IOException;

public class Work {

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
    public static void list() throws IOException {
        EntityData[] entityDats = service.list();

        if (entityDats.length != 0) {
            for (int i = 0; i < entityDats.length; i++) {
                if (entityDats[i] != null) {
                    System.out.println();
                    System.out.println("Login " + entityDats[i].getLogin() +
                            " | FLS: " + entityDats[i].getFirstName() + " " + entityDats[i].getLastName() + " " + entityDats[i].getSurName() +
                            " | Date of birth : " + entityDats[i].getDayOfBirth() + "/" + entityDats[i].getMonthOfBirth() + "/" + entityDats[i].getYearOfBirth() +
                            " | Id of passport:" + entityDats[i].getIdOfPassport());
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
            entityDataToUpdate.setLogin(login);
            entityDataToUpdate.setPassword(password);
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

}

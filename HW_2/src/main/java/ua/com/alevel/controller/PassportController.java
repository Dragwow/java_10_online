package ua.com.alevel.controller;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import ua.com.alevel.entity.LostPassport;
import ua.com.alevel.entity.Passport;
import ua.com.alevel.service.PassportService;

public class PassportController {

    private final PassportService passportService = new PassportService();

    public void start() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position;
        while ((position = reader.readLine()) != null) {
            crud(position, reader);
            menu();
        }
    }

    void menu(){
        System.out.println();
        System.out.println("Зарегистрировать паспорт (1)");
        System.out.println("Посмотреть список зарегистрированных паспортов (2)");
        System.out.println("Посмотреть по id паспорт (3)");
        System.out.println("Посмотреть паспорт по Фамилии/Имени/Отчеству (4)");
        System.out.println("Заменить паспорт (5)");
        System.out.println("Зарегистрировать паспорт как утерянный (6)");
        System.out.println("Список потерряных паспортов (7)");
        System.out.println("Вернуть пасорт из утерянных (8)");
        System.out.println("Удалить паспорт (9)");

        System.out.println("Чтобы выйти (exit)");
    }

    void crud(String position, BufferedReader reader) throws IOException{
        switch (position){
            case "1" -> create(reader);
            case "2" -> list();
            case "3" -> listById(reader);
            case "4" -> listByFio(reader);
            case "5" -> update(reader);
            case "6" -> updateToLost(reader);
            case "7" -> listLost();
            case "8" -> updateFromLost(reader);
            case "9" -> delete(reader);
            case "exit" -> System.exit(0);
        }
    }

    void create(BufferedReader reader) throws IOException {
        System.out.print("Введите имя:");
        String firstName2 = reader.readLine();
        System.out.print("Введите фамилию: ");
        String lastName2 = reader.readLine();
        System.out.print("Введите отчество: ");
        String fatherName2 = reader.readLine();
        System.out.print("Введите возраст: ");
        int age2 = Integer.parseInt(reader.readLine());
        Passport passport = new Passport();
        passport.setFirstName(firstName2);
        passport.setLastName(lastName2);
        passport.setFatherName(fatherName2);
        passport.setAge(age2);
        passportService.create(passport);
    }

    void list() {
        Passport[] passports = passportService.findAll();
        for (int i = 0; i < passports.length; i++) {
            if (passports[i] != null) {
                System.out.println("ID: " + i +
                        ", ФИО: " + passports[i].getFirstName() + " " + passports[i].getLastName() + " " + passports[i].getFatherName() + " " +
                        ", Возраст: " + passports[i].getAge());
            }
            else {
                System.out.println("Паспортов в списке нет");
                break;
            }
        }
    }

    void listById(BufferedReader reader) throws IOException{
        System.out.println("Введите ID: ");
        String idString = reader.readLine();
        int id = Integer.parseInt(idString);
        Passport passport = passportService.findById(id);
        if (passport != null) {
            System.out.println("ID: " + id +
                    ", ФИО: " + passport.getFirstName() + " " + passport.getLastName() + " " + passport.getFatherName() + " " +
                    ", Возраст: " + passport.getAge());
        }
        else System.out.println("Паспорта не существует с таким ID");
    }

    void listByFio(BufferedReader reader) throws IOException {
        System.out.println("Введите полностью ФИО(через пробел)");
        String fioString = reader.readLine();

        Passport passportToSearch = new Passport();
        String[] fioParts = fioString.split(" ");
        if (fioParts.length >= 1) {
            passportToSearch.setLastName(fioParts[0]);
        }
        if (fioParts.length >= 2) {
            passportToSearch.setFirstName(fioParts[1]);
        }
        if (fioParts.length >= 3) {
            passportToSearch.setFatherName(fioParts[2]);
        }
        Passport[] passports = passportService.findByFio(passportToSearch);
        if (passports.length > 0) {
            for (Passport passport : passports) {
                System.out.println("ID: " + passport.getId() +
                        ", ФИО: " + passport.getFirstName() + " " + passport.getLastName() + " " + passport.getFatherName() +
                        ", Возраст: " + passport.getAge());
            }
        } else {
            System.out.println("Паспорта не существует с таким ФИО");
        }
    }

    void update(BufferedReader reader) throws IOException{
        System.out.println("Введите ID: ");
        String idString = reader.readLine();
        int id = Integer.parseInt(idString);
        Passport passport = passportService.findById(id);
        if (passport != null){
            System.out.print("Введите имя: ");
            String firstName = reader.readLine();
            System.out.print("Введите фамилию: ");
            String lastName = reader.readLine();
            System.out.print("Введите отчество: ");
            String fatherName = reader.readLine();
            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(reader.readLine());
            passport = new Passport();
            passport.setFirstName(firstName);
            passport.setLastName(lastName);
            passport.setFatherName(fatherName);
            passport.setAge(age);
            passport.setId(id);
            passportService.update(passport);
        }
        else System.out.println("Паспорта не существует с таким ID");
    }

    void updateToLost(BufferedReader reader) throws IOException{
        System.out.println("Введите ID: ");
        String idString = reader.readLine();
        int id = Integer.parseInt(idString);
        Passport passport = passportService.findById(id);
        if (passport != null){
            System.out.print("Введите имя потерянного паспорта: ");
            String lostFirstName = reader.readLine();
            System.out.print("Введите фамилию потерянного паспорта: ");
            String lostLastName = reader.readLine();
            System.out.print("Введите отчество потерянного паспорта: ");
            String lostFatherName = reader.readLine();
            System.out.print("Введите возраст потерянного паспорта: ");
            int lostAge = Integer.parseInt(reader.readLine());
            LostPassport lostPassport = new LostPassport();
            lostPassport.setLostFirstName(lostFirstName);
            lostPassport.setLostLastName(lostLastName);
            lostPassport.setLostFatherName(lostFatherName);
            lostPassport.setLostAge(lostAge);
            lostPassport.setLostId(id);
            passportService.updateToLost(lostPassport);
            passportService.delete(id);

        }else System.out.println("Паспорта не существует с таким ID");
    }

    void listLost() {
        LostPassport[] lostPassports = passportService.lostFindAll();
        for (int i = 0; i < lostPassports.length; i++) {
            if (lostPassports[i] != null) {
                System.out.println("ID: " + i +
                        ", ФИО: " + lostPassports[i].getLostFirstName() + " " + lostPassports[i].getLostLastName() + " " + lostPassports[i].getLostFatherName() + " " +
                        ", Возраст: " + lostPassports[i].getLostAge());
            }else {
                System.out.println("Паспортов в списке нет");
                break;
            }

        }
    }

    void updateFromLost(BufferedReader reader) throws IOException{
        System.out.println("Введите ID: ");
        String idString = reader.readLine();
        int lostId = Integer.parseInt(idString);
        LostPassport lostPassport = passportService.findByLostId(lostId);
        if (lostPassport != null){
            System.out.print("Введите имя: ");
            String firstName3 = reader.readLine();
            System.out.print("Введите фамилию: ");
            String lastName3 = reader.readLine();
            System.out.print("Введите отчество: ");
            String fatherName3 = reader.readLine();
            System.out.print("Введите возраст: ");
            int age3 = Integer.parseInt(reader.readLine());
            Passport passport = new Passport();
            passport.setFirstName(firstName3);
            passport.setLastName(lastName3);
            passport.setFatherName(fatherName3);
            passport.setAge(age3);
            passport.setId(lostId);
            passportService.create(passport);
            passportService.lostDelete(lostId);
        }
        else System.out.println("Паспорта не существует с таким ID");
    }

    void delete(BufferedReader reader ) throws IOException {
        System.out.println("Введите ID: ");
        String idString = reader.readLine();
        int id = Integer.parseInt(idString);
        Passport passport = passportService.findById(id);
        if (passport != null){
            passportService.delete(id);
        }else System.out.println("Паспорта не существует с таким ID");
    }
}

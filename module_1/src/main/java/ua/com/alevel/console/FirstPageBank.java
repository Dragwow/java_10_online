package ua.com.alevel.console;

import ua.com.alevel.Work.WorkAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstPageBank {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position;
        while ((position = reader.readLine()) != null) {
            crud(reader, position);
            menu();
        }
    }

    void menu() {
        System.out.println();
        System.out.println("Register (1)");
        System.out.println("Profile (2)");
        System.out.println("Login as administrator (3)");
        System.out.println("Get debit card (4)");
        System.out.println("(exit)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch(position){
            case "1" -> create(reader);
            case "2" -> goToProfile(reader);
            case "3" -> logAdmin(reader);
            case "4" -> debitCard(reader);
            case "exit" -> System.exit(0);
        }
    }

    void create(BufferedReader reader) throws IOException{
        WorkAccount.create(reader);
    }

    void goToProfile(BufferedReader reader) throws IOException{
        LogIn logIn = new LogIn();
        logIn.start(reader);
    }
    void logAdmin(BufferedReader reader) throws IOException{
        LogIn logIn = new LogIn();
        logIn.adminStart(reader);
    }

    void debitCard(BufferedReader reader) throws IOException{

    }
}

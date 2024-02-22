package ua.com.alevel.console;

import ua.com.alevel.Work.WorkAcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstPage {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position;
        while ((position = reader.readLine()) != null) {
            crud(reader, position);
            menu();
        }
    }

    void menu(){
        System.out.println();
        System.out.println("Sign up (1)");
        System.out.println("Your account (2)");
        System.out.println("Profile Admin (3)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch (position){
            case "1" -> createAcc(reader);
            case "2" -> profile(reader);
            case "3" -> logAdmin(reader);
        }
    }

    void createAcc(BufferedReader reader) throws IOException{
        WorkAcc.create(reader);
    }

    void logAdmin(BufferedReader reader) throws IOException {
        WorkAcc.logInAdmin(reader);
    }

    void profile(BufferedReader reader) throws IOException{
        WorkAcc.logInStart(reader);
    }

}

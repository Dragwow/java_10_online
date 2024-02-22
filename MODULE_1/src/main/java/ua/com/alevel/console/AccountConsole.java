package ua.com.alevel.console;

import ua.com.alevel.Work.WorkAcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountConsole {

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
        System.out.println("Change data account (1)");
        System.out.println("Reset password (2)");
        System.out.println("Delete account (3)");
        System.out.println("Show info account (4)");
        System.out.println("Sign up for rehabilitation (5)");
        System.out.println("(return)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch(position){
            case "1" -> update(reader);
            case "2" -> reset(reader);
            case "3" -> delete(reader);
            case "4" -> showInfo(reader);
            case "5" -> group(reader);

            case "return" -> new FirstPage().start();
        }
    }

    void update(BufferedReader reader) throws IOException {
       WorkAcc.update(reader);
    }

    void reset(BufferedReader reader) throws IOException{
        WorkAcc.reset(reader);
    }

    void delete(BufferedReader reader) throws IOException{
        WorkAcc.delete(reader);
    }

    void showInfo(BufferedReader reader) throws IOException{
        WorkAcc.showInfo(reader);
    }

    void group(BufferedReader reader) throws IOException{
        WorkAcc.addGroup(reader);
    }




}

package ua.com.alevel.console;


import ua.com.alevel.Work.WorkAccount;
import ua.com.alevel.Work.WorkCredit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Account {



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
        System.out.println("If you want to get credit (2)");
        System.out.println("Reset password (3)");
        System.out.println("Return part of the credit (4)");
        System.out.println("Delete account (5)");
        System.out.println("(return)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch(position){
            case "1" -> update(reader);
            case "2" -> createCred(reader);
            case "3" -> updatePassword(reader);
            case "4" -> retPartCred(reader);
            case "5" -> delete(reader);
            case "return" -> back();
        }
    }



    void update(BufferedReader reader) throws IOException{
        WorkAccount.update(reader);
    }

    void delete(BufferedReader reader) throws IOException{
        WorkAccount.delete(reader);
    }

    void createCred(BufferedReader reader) throws IOException{
        WorkCredit.createCred(reader);
    }

    void updatePassword(BufferedReader reader) throws IOException{
        WorkAccount.updatePassword(reader);
    }

    void back() throws IOException{
        FirstPageBank firstPageBank = new FirstPageBank();
        firstPageBank.start();
    }

    void retPartCred(BufferedReader reader) throws IOException{

    }
}

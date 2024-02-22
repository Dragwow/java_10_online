package ua.com.alevel.console;

import ua.com.alevel.Work.WorkAcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminConsole {



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
        System.out.println("Show accounts (1)");
        System.out.println("Show all groups (2)");
        System.out.println("Show group users (3)");
        System.out.println("Find account by Id (4)");
        System.out.println("Show Id group, account (5)");
        System.out.println("return");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch (position){
            case "1" -> showAll();
            case "2" -> showGroups();
            case "3" -> group(reader);
            case "4" -> findAccountByID(reader);
            case "5" -> showAccountGroup();
            case "return" -> new FirstPage().start();
        }
    }

    void showAll() {
        WorkAcc.showAll();
    }

    void group(BufferedReader reader) throws IOException{
        WorkAcc.showGroups(reader);
    }

    void showGroups() {
        WorkAcc.showGroupsInfo();
    }

    void findAccountByID(BufferedReader reader) throws IOException{
        WorkAcc.findAccountById(reader);
    }

    void showAccountGroup() {
        WorkAcc.showAccountGroup();
    }
}

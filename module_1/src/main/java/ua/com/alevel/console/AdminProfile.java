package ua.com.alevel.console;

import ua.com.alevel.Work.WorkAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminProfile {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position;
        while ((position = reader.readLine()) != null) {
            crud(position);
            menu();

        }
    }

    void menu() {
        System.out.println();
        System.out.println("View registered accounts (1)");
        System.out.println("View accounts who have credit (2)");
        System.out.println("View users plastic cards (3)");
        System.out.println("(return)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(String position) throws IOException{
        switch(position){
            case "1" -> list();
            case "2" -> listCred();
            case "3" -> listPlastic();
            case "return" -> back();
        }
    }
    void back() throws IOException{
        FirstPageBank firstPageBank = new FirstPageBank();
        firstPageBank.start();
    }
    void list(){
        WorkAccount.list();
    }

    void listCred(){
        WorkAccount.listCred();
    }

    void listPlastic(){
        WorkAccount.listPlastic();
    }
}

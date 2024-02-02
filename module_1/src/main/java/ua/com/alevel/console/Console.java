package ua.com.alevel.console;

import ua.com.alevel.Work.Work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

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
        System.out.println("View registered accounts (2)");
        System.out.println("Update data account (3)");
        System.out.println("If you want to get credit (4)");
        System.out.println("View accounts who have credit (5)");
        System.out.println("Delete account (6)");
        System.out.println("(exit)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch(position){
            case "1" -> create(reader);
            case "2" -> list();
            case "3" -> update(reader);
            case "4" -> createCred(reader);
            case "5" -> listCred();
            case "6" -> delete(reader);
            case "exit" -> System.exit(0);
        }
    }

    void create(BufferedReader reader) throws IOException{
        Work.create(reader);
    }

    void list() {
        Work.list();
    }

    void update(BufferedReader reader) throws IOException{
        Work.update(reader);
    }

    void delete(BufferedReader reader) throws IOException{
        Work.delete(reader);
    }

    void createCred(BufferedReader reader) throws IOException{
        Work.createCred(reader);
    }
    void listCred() {
        Work.listCred();
    }
}

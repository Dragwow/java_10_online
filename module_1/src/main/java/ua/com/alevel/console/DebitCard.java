package ua.com.alevel.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DebitCard {
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
        System.out.println("Get plastic card (1)");
        System.out.println("Get platinum card (2)");
        System.out.println("Get gold card (3)");
        System.out.println("(return)");
        System.out.println();
        System.out.print("Enter: ");
    }

    void crud(BufferedReader reader, String position) throws IOException{
        switch(position){
            case "1" -> getPlastic(reader);
            case "return" -> back();
        }
    }

    void back() throws IOException{
        FirstPageBank firstPageBank = new FirstPageBank();
        firstPageBank.start();
    }

    void getPlastic(BufferedReader reader) throws IOException{

    }
}

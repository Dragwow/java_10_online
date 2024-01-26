package ua.com.alevel.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position;
        while ((position = reader.readLine()) != null) {
            crud(position, reader);
            menu();
        }
    }

    void menu() throws IOException{
        System.out.println();
        System.out.println("If you want register (1)");
        System.out.println("If you want saw registered accounts (2)");
        System.out.println("If");
    }
}

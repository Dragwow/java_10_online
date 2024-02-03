package ua.com.alevel;

import java.io.IOException;

import ua.com.alevel.console.FirstPageBank;

public class Main {
    public static void main(String[] args) throws IOException {
        FirstPageBank firstPageBank = new FirstPageBank();
        firstPageBank.start();
    }
}
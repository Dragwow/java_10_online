package ua.com.alevel;

import  ua.com.alevel.controller.PassportController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PassportController passportController = new PassportController();
        passportController.start();
    }
}
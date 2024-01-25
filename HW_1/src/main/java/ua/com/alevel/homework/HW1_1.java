package ua.com.alevel.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HW1_1 {
    public void number() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String valueInput = reader.readLine();
        int sum = 0;

        for (int i = 0; i < valueInput.length(); i++) {
            char currentChar = valueInput.charAt(i);
            if (Character.isDigit(currentChar)) {
                sum += Character.getNumericValue(currentChar);
            }
        }
        System.out.println("Сумма цифр в строке: " + sum);
    }
}
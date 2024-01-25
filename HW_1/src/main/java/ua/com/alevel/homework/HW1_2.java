package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW1_2 {
    public void word() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите строку: ");
        String valueInput = reader.readLine();

        char[] chars = new char[3000];
        int[] num = new int[3000];
        int sum = 0;

        for (int i = 0; i < valueInput.length(); i++) {
            char c = valueInput.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я')) {
                int index = indexOf(chars, sum, c);
                if (index == -1) {
                    chars[sum] = c;
                    num[sum]++;
                    sum++;
                } else {
                    num[index]++;
                }
            }
        }
        System.out.println("Количество букв в строке :");
        for (int i = 0; i < sum; i++) {
            System.out.println(chars[i] + ": " + num[i]);
        }
    }

    private static int indexOf(char[] array, int size, char target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

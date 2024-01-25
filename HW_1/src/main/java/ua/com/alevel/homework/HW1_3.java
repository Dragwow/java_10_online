package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW1_3 {
    public void school() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите номер урока: ");
        String lesson = reader.readLine();
        int hour = Integer.parseInt(lesson);

        int lessonHour = 45;

        int totalMinutes = (hour - 1) * (lessonHour + 5) + (hour / 2) * 10 + lessonHour;
        int endHour = 9 + totalMinutes / 60;
        int endMinute = totalMinutes % 60;

        System.out.println(endHour + ":" + endMinute);
    }
}
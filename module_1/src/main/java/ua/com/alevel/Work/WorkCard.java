package ua.com.alevel.Work;

import ua.com.alevel.Entity.EntityData;
import ua.com.alevel.Service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class WorkCard {

    private static final Service service = new Service();

    public static void plasticCard(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.print("Please enter id of passport:");
        String idOfPassport = reader.readLine();
        System.out.print("Please enter date of birth (dd/mm/yy)");

        String date = reader.readLine();
        EntityData dateToSearch = new EntityData();
        String[] dateParts = date.split("/");
        int[] dateInt = new int[]{Integer.parseInt(Arrays.toString(dateParts))};
        if (dateParts.length >= 1) {
            dateToSearch.setDayOfBirth(dateInt[0]);
        }
        if (dateParts.length >= 2) {
            dateToSearch.setMonthOfBirth(dateInt[1]);
        }
        if (dateParts.length >= 3) {
            dateToSearch.setYearOfBirth(dateInt[2]);
        }
        
    }
}

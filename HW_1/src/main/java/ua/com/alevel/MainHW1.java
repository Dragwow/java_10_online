package ua.com.alevel;

import ua.com.alevel.homework.HW1_1;
import ua.com.alevel.homework.HW1_2;
import ua.com.alevel.homework.HW1_3;

import java.io.IOException;
public class MainHW1 {
    public static void main(String[] args) throws IOException {
        HW1_1 HW1_1 = new HW1_1();
        HW1_2 HW1_2 = new HW1_2();
        HW1_3 HW1_3 = new HW1_3();
        HW1_1.number();
        HW1_2.word();
        HW1_3.school();
    }
}
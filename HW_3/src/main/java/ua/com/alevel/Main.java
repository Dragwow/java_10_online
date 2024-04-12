package ua.com.alevel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static String reverse(String src) {
        char[] charArray = src.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return new String(charArray);
    }

    public static String reverse(String src, String dest) {
        int startIndex = src.indexOf(dest);
        if (startIndex == -1) {
            return src;
        }

        int endIndex = startIndex + dest.length() - 1;
        return reverse(src, startIndex, endIndex);
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        char[] charArray = src.toCharArray();

        while (firstIndex < lastIndex) {
            char temp = charArray[firstIndex];
            charArray[firstIndex] = charArray[lastIndex];
            charArray[lastIndex] = temp;

            firstIndex++;
            lastIndex--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter:");
        String word = reader.readLine();
        System.out.print("Enter:");
        String word2 = reader.readLine();
        System.out.print("Enter number 1:");
        int num = Integer.parseInt(reader.readLine());
        System.out.print("Enter number 2:");
        int num2 = Integer.parseInt(reader.readLine());
        System.out.println(reverse(word));
        System.out.println(reverse(word, word2));
        System.out.println(reverse(word, num, num2));
    }
}
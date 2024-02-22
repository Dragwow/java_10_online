package ua.com.alevel;


import java.io.BufferedReader;
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
        if (firstIndex < 0 || lastIndex >= src.length() || firstIndex > lastIndex) {
            throw new IllegalArgumentException("Invalid indices");
        }

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

    public static void main(String[] args) {
        System.out.println(reverse("hello world"));
        System.out.println(reverse("hello world", "worl"));
        System.out.println(reverse("hello world", 3, 7));
    }
}
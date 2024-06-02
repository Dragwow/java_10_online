package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Text :");
            String text = reader.readLine();
            System.out.printf("%-10s %-10s %-10s %-10s \n", "", "Rating", "Count", "Percentage");
            process(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void process(String text) {
        List<String> wordList = Arrays.stream(text.split("\\W+"))
                .filter(w -> !w.isEmpty())
                .map(String::toLowerCase)
                .toList();

        int size = wordList.size();

        Map<String, Long> map = wordList.stream()
                .collect(groupingBy(w -> w, counting()));

        List<Word> toSort = new ArrayList<>();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            Word word1 = new Word(entry.getKey(), entry.getValue(), (entry.getValue() * 100.0) / size);
            toSort.add(word1);
        }
        toSort.sort(Comparator.comparing(Word::getPercentage).reversed());
        List<Word> words = new ArrayList<>();
        for (Word word1 : toSort) {
            word1.setRating(words.indexOf(word1) + 1);
            Word apply = word1;
            words.add(apply);
        }

        words.forEach(w -> System.out.printf("%-13s %-10s %-10s %-10s \n", w.getWord(), w.getRating(), w.getCount(), String.format("%.2f", w.getPercentage())));
    }
}
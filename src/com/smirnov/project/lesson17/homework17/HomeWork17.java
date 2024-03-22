package com.smirnov.project.lesson17.homework17;

import java.util.*;

import static java.lang.Math.min;

public class HomeWork17 {
    private HomeWork17() {
    }

    /**
     * Возвращает количество одинаковых слов в коллекции в виде Map.
     *
     * @param strings Коллекция слов
     * @return Map, где ключи - слова, а значения - количество повторений.
     */
    public static Map<String, Long> frequencyOfWord(Collection<String> strings) {
        Objects.requireNonNull(strings);
        if (strings.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, Long> wordMap = new HashMap<>();
        for (String string : strings) {
            if (string != null && !string.isBlank()) {
                wordMap.put(string.toLowerCase(), wordMap.getOrDefault(string.toLowerCase(), 0L) + 1L);
            }
        }
        return wordMap;
    }

    /**
     * Возвращает частоту встречаемости слова в тексте text в виде Map, где ключ - слово,
     * а значение - частота встречаемости.
     *
     * @param text Текст
     * @param word Слово
     * @return Map, где ключ - слово, значение - частота встречаемости
     */
    public static Map<String, Long> frequencyOfWord(String text, String word) {
        Objects.requireNonNull(text);
        Objects.requireNonNull(word);
        if (word.isBlank()) {
            throw new IllegalArgumentException("word is blank");
        }
        if (text.isBlank()) {
            Map<String, Long> wordMap = new HashMap<>();
            wordMap.put(word, 0L);
            return wordMap;
        }
        Map<String, Long> wordMap = new HashMap<>();
        String[] words = text.split(" ");
        long counter = 0;
        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                counter++;
            }
        }
        return Map.of(word, counter);
    }


    /**
     * Возвращает Map, где ключи - количество букв в словах, значения - список слов.
     *
     * @param text Текст
     * @return Map
     */
    public static Map<Integer, List<String>> numberOfLettersInWords(String text) {
        Objects.requireNonNull(text);
        if (text.isBlank()) {
            return new HashMap<>();
        }
        Map<Integer, List<String>> numberOfLetterAndWords = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (!word.isBlank()) {
                if (numberOfLetterAndWords.containsKey(word.length())) {
                    if (!numberOfLetterAndWords.get(word.length()).contains(word)) {
                        numberOfLetterAndWords.get(word.length()).add(word);
                    }
                } else {
                    numberOfLetterAndWords.put(word.length(), new ArrayList<>(List.of(word)));
                }
            }
        }
        return numberOfLetterAndWords;
    }

    /**
     * Выводит на экран топ 10 слов.
     */
    public static void topTenWord(String text) {
        Objects.requireNonNull(text);
        if (text.isBlank()) {
            System.out.println("Список пустой");
        }
        int topWord = 10;
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (!word.isBlank()) {
                wordsMap.put(word.toLowerCase(), wordsMap.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> wordTopList = new ArrayList<>(wordsMap.entrySet());
        wordTopList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - (o1.getValue());
            }
        });
        int length = min(wordTopList.size(), topWord);
        for (int i = 0; i < length; i++) {
            System.out.print(wordTopList.get(i).getKey() + ", ");
        }
    }
}

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
     * @return Map<String, Long>, где ключи - слова, а значения - количество повторений.
     */
    static Map<String, Long> frequencyOfWord(Collection<String> strings) {
        Objects.requireNonNull(strings);
        if (strings.isEmpty()) return new HashMap<>();
        Map<String, Long> wordMap = new HashMap<>();
        for (String string : strings) {
            if (!string.isBlank()) {
                wordMap.put(string, wordMap.getOrDefault(string.toLowerCase(), 0L) + 1L);
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
    static Map<String, Long> frequencyOfWord(String text, String word) {
        Objects.requireNonNull(text);
        Objects.requireNonNull(word);
        if (word.isBlank()) throw new IllegalArgumentException("word is blank");
        if (text.isBlank()) return new HashMap<>();
        Map<String, Long> wordMap = new HashMap<>();
        String[] words = text.split(" ");
        long counter = 0;
        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                counter++;
            }
        }
        wordMap.put(word, counter);
        return wordMap;
    }


    /**
     * Возвращает Map, где ключи - количество букв в словах, значения - список слов.
     *
     * @param text Текст
     * @return Map
     */
    static Map<Integer, List<String>> numberOfLettersInWords(String text) {
        Objects.requireNonNull(text);
        if (text.isBlank()) return new HashMap<>();
        Map<Integer, List<String>> numberOfLetterAndWords = new HashMap<>();
        List<String> wordList = new ArrayList<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (!word.isBlank()) {
                wordList.add(word);
            }
        }
        numberOfLetterAndWords.put(text.replaceAll(" ", "").length(), wordList);
        return numberOfLetterAndWords;
    }

    /**
     * Выводит на экран топ 10 слов.
     *
     * @param text Текст
     */
    public static void topTenWord(String text) {
        Objects.requireNonNull(text);
        if (text.isBlank()) System.out.println("Список пустой");
        int topWord = 10;
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (!word.isBlank()) {
                wordsMap.put(word, wordsMap.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> wordTopMap = new ArrayList<>(wordsMap.entrySet());
        wordTopMap.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - (o1.getValue());
            }
        });
        List<String> wordTop = new ArrayList<>(topWord);
        int length = min(wordTopMap.size(), topWord);
        for (int i = 0; i < length; i++) {
            wordTop.add(wordTopMap.get(i).getKey());
        }
        System.out.println(wordTop);
    }
}

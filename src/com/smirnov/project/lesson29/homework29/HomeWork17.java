package com.smirnov.project.lesson29.homework29;

import java.util.*;
import java.util.logging.Logger;

import static java.lang.Math.min;
import static java.lang.Runtime.getRuntime;
import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class HomeWork17 {
    private static final Logger LOGGER = Logger.getLogger(HomeWork17.class.getName());

    private HomeWork17() {
    }

    /**
     * Вспомогательный класс формирует мапу для работы со словами в потоке
     */
    private static class FormingMap extends Thread {
        final String[] stringWords;
        final Map<String, Integer> wordsMap = new HashMap<>();

        FormingMap(String[] stringWords) {
            this.stringWords = stringWords;
        }

        @Override
        public void run() {
            Arrays.stream(stringWords).filter(string -> !string.isBlank())
                    .forEach(word -> wordsMap.put(word.toLowerCase(), wordsMap.getOrDefault(word.toLowerCase(), 0) + 1));
        }
    }

    /**
     * Вспомогательный класс, который перемещает данные из мапы одного потока в мапу другого потока
     */
    private static class MergeMap extends Thread {
        final Map<String, Integer> map1;
        final Map<String, Integer> map2;

        MergeMap(Map<String, Integer> map1, Map<String, Integer> map2) {
            this.map1 = map1;
            this.map2 = map2;
        }

        @Override
        public void run() {
            map2.keySet().forEach(key -> {
                if (map1.containsKey(key)) {
                    map1.replace(key, map1.get(key) + map2.get(key));
                } else {
                    map1.put(key, map2.get(key));
                }
            });
        }
    }


    /**
     * Выводит топ 10 слов на экран
     */
    public static void topTenWords(String text) {
        requireNonNull(text);
        if (text.isBlank()) {
            return;
        }
        String[] textSplit = text.split(" ");
        if (textSplit.length == 1) {
            out.println(textSplit[0].toLowerCase());
            return;
        }
        int process = min(getRuntime().availableProcessors(), textSplit.length - textSplit.length % 2);
        int numberOfWordsInStream = textSplit.length / process;
        FormingMap[] formingMapsForStream = new FormingMap[process];
        for (int i = 0; i < process; i++) {
            int left = i * numberOfWordsInStream;
            int right = i < process - 1 ? (i + 1) * numberOfWordsInStream : textSplit.length;
            String[] arraysWordsForStream = new String[right - left];
            arraycopy(textSplit, left, arraysWordsForStream, 0, right - left);
            formingMapsForStream[i] = new FormingMap(arraysWordsForStream);
            formingMapsForStream[i].start();
        }
        Arrays.stream(formingMapsForStream).forEach((formingMap -> {
                    try {
                        formingMap.join(1000);
                    } catch (InterruptedException e) {
                        LOGGER.info("Поток остановился");
                        formingMap.interrupt();
                    }
                })
        );
        int stepCountForming = 1;
        while (process != 1) {
            MergeMap[] mergeMaps = new MergeMap[process / 2];
            int countForming = 0;
            for (int i = 0; i < mergeMaps.length; i++) {
                mergeMaps[i] = new MergeMap(formingMapsForStream[countForming].wordsMap, formingMapsForStream[countForming + stepCountForming].wordsMap);
                countForming += 2 * stepCountForming;
                mergeMaps[i].start();
            }
            process = process / 2 + process % 2;
            stepCountForming += stepCountForming;
            Arrays.stream(mergeMaps).forEach(mergeMap -> {
                        try {
                            mergeMap.join(2000);
                        } catch (InterruptedException e) {
                            LOGGER.info("Поток остановился");
                            mergeMap.interrupt();
                        }
                    }
            );
        }
        int topWord = 10;
        List<Map.Entry<String, Integer>> wordTopList = new ArrayList<>(formingMapsForStream[0].wordsMap.entrySet());
        wordTopList.sort((o1, o2) -> o2.getValue() - (o1.getValue()));
        int length = min(wordTopList.size(), topWord);
        for (int i = 0; i < length; i++) {
            out.printf("%s; ", wordTopList.get(i).getKey());
        }
    }
}

package com.smirnov.project.lesson29.homework29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static java.lang.Math.min;
import static java.lang.Runtime.getRuntime;
import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HomeWork17 {
    private static final Logger LOGGER = Logger.getLogger(HomeWork17.class.getName());

    private HomeWork17() {
    }

    /**
     * Вспомогательный класс формирует мапу для работы со словами в потоке
     */
    private static class FormingMap extends Thread {
        final String[] stringWords;
        Map<String, Long> wordsMap;

        FormingMap(String[] stringWords) {
            this.stringWords = stringWords;
        }

        @Override
        public void run() {
            wordsMap = Arrays.stream(stringWords)
                    .collect(groupingBy(
                            string -> string,
                            counting()
                    ));

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
        String[] textSplit = text.toLowerCase().split(" ");
        if (textSplit.length == 1) {
            out.println(textSplit[0].toLowerCase());
            return;
        }
        int process = min(getRuntime().availableProcessors(), textSplit.length);
        int numberOfWordsInStream = textSplit.length / process;
        FormingMap[] formingMapsForStream = new FormingMap[process];
        for (int i = 0; i < process; i++) {
            int left = i * numberOfWordsInStream;
            int right = i < process - 1 ? (i + 1) * numberOfWordsInStream : textSplit.length;
            String[] arraysWordsForStream = new String[right - left];
            arraycopy(textSplit, left, arraysWordsForStream, 0, right - left);
            formingMapsForStream[i] = new FormingMap(arraysWordsForStream);
            formingMapsForStream[i].start();
            out.println(Arrays.toString(arraysWordsForStream));
        }
        Arrays.stream(formingMapsForStream).forEach((formingMap -> {
                    try {
                        formingMap.join(2000);
                        out.println(formingMap.wordsMap);
                    } catch (InterruptedException e) {
                        LOGGER.info("Поток остановился");
                        formingMap.interrupt();
                    }
                })
        );
        Map<String, Long> finalmap=new HashMap<>();
        Arrays.stream(formingMapsForStream)
                .map(formingMap -> formingMap.wordsMap)
                .flatMap(wordsMap -> wordsMap.entrySet().stream())
                .forEach(stringLongEntry -> {
            if (!finalmap.containsKey(stringLongEntry.getKey())) {
                finalmap.put(stringLongEntry.getKey(), stringLongEntry.getValue());
            } else {
                finalmap.replace(stringLongEntry.getKey(), stringLongEntry.getValue() + finalmap.get(stringLongEntry.getKey()));
            }
        });
      /*  Map<String, Long> finalmap = Arrays.stream(formingMapsForStream)
                .map(formingMap -> formingMap.wordsMap)
                .flatMap(wordsMap -> wordsMap.entrySet().stream())
                .collect(groupingBy(
                        Map.Entry::getKey,
                        counting()
                ));*/
        out.println(finalmap);
        int topWord = 10;
        finalmap.entrySet()
                .stream()
                .sorted((o1, o2) -> (int) (o2.getValue() - (o1.getValue())))
                .limit(topWord)
                .forEach(word -> out.printf("%s; ", word.getKey()));


    }
}

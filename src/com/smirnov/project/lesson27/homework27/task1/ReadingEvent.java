package com.smirnov.project.lesson27.homework27.task1;

import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

/**
 * Читает файлы.
 */
public class ReadingEvent extends Thread {
    /**
     * Путь к файлу.
     */
    private final String pathFile;
    /**
     * Позиция приоритетов в файле.
     */
    private final int positionPriority;

    /**
     * Интересующий уровень приоритета.
     */
    private final int levelPriority;
    /**
     * Позиция текстового описания.
     */
    private static final int POSITION_TEXT = 2;
    /**
     * Разделитель
     */
    private final String separator;

    /**
     * Количество событий с высоким приоритетом
     */
    private int countPriority;

    /**
     * Конструктор создает объект для чтения из файла
     *
     * @param pathFile         Путь к файлу
     * @param positionPriority Расположение приоритета в файле
     * @param separator        Разделитель
     * @param levelPriority    Уровень приоритета
     */
    public ReadingEvent(String pathFile, int positionPriority, String separator, int levelPriority) {
        this.pathFile = requireNonNull(pathFile);
        this.separator = requireNonNull(separator);
        if (positionPriority < 1 || levelPriority < 1 || positionPriority > 10 || levelPriority > 10) {
            throw new IllegalArgumentException("levelPriority и positionPriority должны иметь значения от 1 до 10 включительно");
        }
        this.positionPriority = positionPriority;
        this.levelPriority = levelPriority;
    }

    @Override
    public void run() {
        countPriority = 0;
        try {
            newBufferedReader(Path.of(pathFile))
                    .lines()
                    .map(string -> string.split(separator))
                    .filter(strings -> parseInt(strings[positionPriority]) >= levelPriority)
                    .forEach(strings -> {
                        out.println(strings[POSITION_TEXT]);
                        countPriority++;
                    });
            out.println("В файле"+get(pathFile).getFileName()+" количество задач с приоритетом "+levelPriority+" и выше: "+countPriority);
        } catch (IOException e) {
            out.println("Файл не доступен для чтения");
        }
    }
}

package com.smirnov.project.lesson27.homework27.task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

/**
 * Читает файлы.
 */
public class ReadingEvents extends Thread {
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
    private final int positionText;
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
    public ReadingEvents(String pathFile, int positionPriority, String separator, int levelPriority) {
        this.pathFile = requireNonNull(pathFile);
        this.separator = requireNonNull(separator);
        if (positionPriority < 1 || levelPriority < 1 || positionPriority > 10 || levelPriority > 10) {
            throw new IllegalArgumentException("levelPriority и positionPriority должны иметь значения от 1 до 10 включительно");
        }
        this.positionPriority = positionPriority;
        this.positionText = 2;
        this.levelPriority = levelPriority;
    }

    @Override
    public void run() {
        countPriority = 0;
        try (FileInputStream fileInputStream = new FileInputStream(pathFile)) {
            byte[] readFile = new byte[fileInputStream.available()];
            fileInputStream.read(readFile);
            String stringRead = new String(readFile);
            String[] arrLine = stringRead.split("\n");
            Arrays.stream(arrLine).map(s -> s.split(separator))
                    .filter(arrSplit -> parseInt(arrSplit[positionPriority]) >= levelPriority)
                    .forEach(arrSplit -> {
                        out.println(arrSplit[positionText]);
                        countPriority++;
                    });
        } catch (FileNotFoundException e) {
            out.println("Файл отсутствует");
        } catch (IOException e) {
            out.println("Чтение не доступно");
        }
    }

    public String getPathFile() {
        return pathFile;
    }

    public int getPositionPriority() {
        return positionPriority;
    }

    public int getLevelPriority() {
        return levelPriority;
    }

    public int getCountPriority() {
        return countPriority;
    }
}

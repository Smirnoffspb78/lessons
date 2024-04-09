package com.smirnov.project.courseproject2var2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

/**
 * Игровой процесс
 */
public class Game {

    /**
     * Путь для сохранения и загрузки названия квеста
     */
    private String pathSaveAndDownload;


    public Game(String pathSaveAndDownload) {
        requireNonNull(pathSaveAndDownload);
        this.pathSaveAndDownload = pathSaveAndDownload;
    }

    /**
     * Запускает игровой процесс
     */
    public void startGameProcess(Quest quest) {
        requireNonNull(quest);
        String continueName = quest.getContinueName();
        Scanner scannerGame = new Scanner(in);
        out.println(quest.getTextsMap().get(continueName));
        int id = 0;
        for (String value : quest.getAnswersAndQuestions().get(continueName)) {
            out.printf("%d. %s%n", ++id, value);
        }
        if (quest.getAnswersAndQuestions().get(continueName).size() != 1) {
            int userInput = scannerGame.nextInt();
            if (userInput > quest.getAnswersAndQuestions().get(quest.getContinueName()).size() || userInput < 1) {
                throw new IllegalArgumentException("Введенное число должно совпадать с номером одного из пунктов меню.");
            }
            if (userInput == quest.getAnswersAndQuestions().get(continueName).size()) {
                quest.setTempName(continueName);
            } else {
                quest.setContinueName(quest.getAnswersAndQuestions().get(continueName).get(userInput-1));
                startGameProcess(quest);
            }
        } else {
            quest.setTempName(null);
        }
    }


    /**
     * Изменяет начальное состояние continueName для продолжения игры
     */
    public void continueGame(Quest quest) {
        if (quest.getTempName() != null) {
            quest.setContinueName(quest.getTempName());
            startGameProcess(quest);
        }
    }

    public boolean downloadGame(Quest quest) {

        try {
            quest.setContinueName(Files.readString(get(pathSaveAndDownload)));
            if (quest.getTextsMap().containsKey(quest.getContinueName())) {
                return true;
            }
            out.println("Загрузка не удалась");
            return false;
        } catch (IOException e) {
            out.println("Файл отсутствует");
            return false;
        }
    }

    public boolean saveGame(Quest quest) {
        try {
            writeString(get(pathSaveAndDownload), quest.getTempName(),
                    StandardOpenOption.CREATE //Создать, если нет файла
                    /* StandardOpenOption.APPEND*/); //Дозапись построчная в файле нужна будет при создании имени юзера
        } catch (IOException e) {
            out.println("Ошибка сохранения");
            return false;
        }
        out.println("Игра сохранена.");
        return true;
    }

    public String getPathSaveAndDownload() {
        return pathSaveAndDownload;
    }

    public void setPathSaveAndDownload(String pathSaveAndDownload) {
        this.pathSaveAndDownload = pathSaveAndDownload;
    }
}

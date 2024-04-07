package com.smirnov.project.courseproject2var2;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Игра.
 */
public class Game {

    /**
     * Путь для сохранения и загрузки названия квеста
     */
   /* private final String pathSaveAndDownload = "C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/courseproject2var2/Save Progress.txt";*/

    /**
     * Файл для сохранения и загрузки квеста.
     */
    /*private final File file = new File(pathSaveAndDownload);*/


    /**
     * Временное название квеста.
     */
    /*private String tempName;*/

    /**
     * Текущее название квеста.
     */
    /*private String continueName;*/

    /**
     * Сканер для ввода данных в игровом процессе.
     */
    private final Scanner scannerGame = new Scanner(in);

    /**
     * Конструктор создает игру.
     */

    public Game() {
    }


    /**
     * Запуск игрового процесса.
     *
     * @param numberQuest Наименование квеста.
     */
    public void startGame(/*QuestFile questFile*/) {
        /*requireNonNull(questFile);
        String numberQuest=questFile.getContinueName();
        out.println(questFile.getTextsMap().get(numberQuest));
        questFile.getAnswersAndQuestions().get(numberQuest).forEach((key, value) -> {
            out.printf("%d. ", key);
            out.println(value);
        });
        if (questFile.getAnswersAndQuestions().get(numberQuest).size() != 1) {
            int userInput = scannerGame.nextInt();
            out.println(questFile.getAnswersAndQuestions().get(numberQuest).size());
            if (userInput == questFile.getAnswersAndQuestions().get(numberQuest).size()) {
                tempName = numberQuest;
            } else {
                *//*startGame(questFile.getAnswersAndQuestions()
                        .get(numberQuest)
                        .get(userInput));*//*
            }
        } else {
            tempName = null;
        }*/
    }

    /**
     * Выход из игры.
     */
    public void exitGame() {
        out.println("До новых встреч!");
    }

    /**
     * Сохранение игры.
     *
     * @return true/false Если игра сохранилась/не сохранилась
     */
    public boolean saveGame() {
        /*try {
            writeString(get(pathSaveAndDownload), tempName,
                    StandardOpenOption.CREATE //Создать, если нет файла
                    *//*StandardOpenOption.APPEND*//*); //Дозапись построчная в файле нужна будет при создании имени юзера
        } catch (IOException e) {
            out.println("Ошибка сохранения");
            return false;
        }
        out.println("Игра сохранена.");*/
        return true;
    }

 /*   public String getContinueName() {
        return continueName;
    }

    public String getTempName() {
        return tempName;
    }

    public String getPathSaveAndDownload() {
        return pathSaveAndDownload;
    }*/
}

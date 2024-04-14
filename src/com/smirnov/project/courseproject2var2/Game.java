package com.smirnov.project.courseproject2var2;

import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.nio.file.Files.readString;
import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

/**
 * Игровой процесс.
 */
public class Game {

    /**
     * Дефолтный пункт, который добавляется в конец вариантов ответа.
     */
    private static final String RETURN_MENU = "Вернуться в меню.";
    /**
     * Мапа c квестами, где ключи - названия параграфов, значение - Мапа с вариантами ответов,
     * где ключи - номер варианта ответа, значения - Описание варианта ответа.
     */
    private final Map<String, List<String>> answersAndQuestions;
    /**
     * Мапа с описанием квеста, где ключи - название параграфов, значения - текстовое описание.
     */
    private final Map<String, String> textsMap;

    /**
     * Путь для сохранения и загрузки названия квеста.
     */
    private final String pathSaveAndDownload;

    /**
     * Клиентский ввод.
     */
    private final Scanner scannerGame = new Scanner(in);

    /**
     * Первый квест.
     */
    private final String firstQuest;
    /**
     * Временное наименование квеста.
     */
    private String tempName;

    /**
     * Конструктор создает игровой процесс.
     *
     * @param pathSaveAndDownload     Путь для загрузки игрового процесса
     * @param firstQuest              Первый квест
     * @param firstQuestionsParagraph Первый параграф
     * @param text                    Текст перового параграфа
     */
    public Game(String pathSaveAndDownload, String firstQuest, List<String> firstQuestionsParagraph, String text) {
        List<String> questions = firstQuestionsParagraph.stream()
                .filter(Objects::nonNull)
                .collect(toList());
        questions.add(RETURN_MENU);
        this.firstQuest = requireNonNull(firstQuest);
        this.pathSaveAndDownload = requireNonNull(pathSaveAndDownload);
        answersAndQuestions = new HashMap<>();
        textsMap = new HashMap<>();
        answersAndQuestions.putIfAbsent(firstQuest, questions);
        textsMap.putIfAbsent(firstQuest, text);
    }

    /**
     * Запускает игровой процесс.
     */
    public void startGameProcess(String continueName) {
        requireNonNull(continueName);
        int userInput = 0;
        List<String> qestionList = answersAndQuestions.get(continueName);
        while (qestionList.size() != 1 && userInput != qestionList.size()) {
            out.println(textsMap.get(continueName));
            qestionList = answersAndQuestions.get(continueName);
            for (int i = 0; i < qestionList.size(); i++) {
                out.printf("%d. %s%n", i + 1, qestionList.get(i));
            }
            if (scannerGame.hasNextInt()) {
                userInput = scannerGame.nextInt();
                if (qestionList.size() != 1) {
                    if (userInput > qestionList.size() || userInput < 1) {
                        out.println("Введено неверное значение");
                    } else if (userInput == qestionList.size()) {
                        tempName = continueName;
                    } else {
                        continueName = qestionList.get(userInput - 1);
                    }
                } else {
                    tempName = null;
                }
            } else {
                throw new IllegalArgumentException("введенное значение должно быть целочисленным числом.");
            }
        }
    }


    /**
     * Изменяет начальное состояние continueName для продолжения игры.
     */
    public void continueGame() {
        if (tempName != null) {
            startGameProcess(tempName);
        } else {
            out.println("Загрузка не выполнена");
        }
    }

    /**
     * Загружает игру
     */
    public void downloadGame() {
        try {
            tempName = (readString(get(pathSaveAndDownload)));
            if (textsMap.containsKey(tempName)) {
                startGameProcess(tempName);
            }
            out.println("Загрузка не удалась");
        } catch (IOException e) {
            out.println("Файл отсутствует");
        }
    }

    /**
     * Сохраняет игру
     */
    public void saveGame() {
        try {
            writeString(get(pathSaveAndDownload), tempName,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            out.println("Ошибка сохранения");
        }
        out.println("Игра сохранена.");
    }

    /**
     * Добавляет параграф в текстовый квест.
     *
     * @param nameParagraph      Имя параграфа
     * @param questionsParagraph Выбор действия
     * @param text               Текстовое описание
     */
    public void addAnswersAndQuestions(String nameParagraph, List<String> questionsParagraph, String text) {
        requireNonNull(nameParagraph);
        requireNonNull(text);
        requireNonNull(questionsParagraph);
        List<String> questions = questionsParagraph.stream()
                .filter(Objects::nonNull)
                .collect(toList());
        questions.add(RETURN_MENU);
        answersAndQuestions.putIfAbsent(nameParagraph, questions);
        textsMap.putIfAbsent(nameParagraph, text);
    }

    public String getPathSaveAndDownload() {
        return pathSaveAndDownload;
    }

    public String getFirstQuest() {
        return firstQuest;
    }

    public String getTempName() {
        return tempName;
    }

    @Override
    public String toString() {
        return "Quest{, answersAndQuestions=%s}".formatted(answersAndQuestions);
    }
}

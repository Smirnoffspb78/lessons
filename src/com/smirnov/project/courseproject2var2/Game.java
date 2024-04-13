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
import static java.util.stream.Collectors.*;

/**
 * Игровой процесс
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
    private final Map<String, List<String>> answersAndQuestions = new HashMap<>();
    /**
     * Мапа с описанием квеста, где ключи - название параграфов, значения - текстовое описание.
     */
    private final Map<String, String> textsMap = new HashMap<>();

    /**
     * Ввод пользователя
     */
    private Scanner scannerGame = new Scanner(in);
    /**
     * Путь для сохранения и загрузки названия квеста
     */
    private final String pathSaveAndDownload;

    /**
     * Временное наименование квеста
     */
    private String tempName;

    private final String firstQuest;

    public Game(String pathSaveAndDownload, String firstQuest, List<String> firstQuestionsParagraph, String text) {
        addAnswersAndQuestions(firstQuest, firstQuestionsParagraph, text);
        this.firstQuest = firstQuest;
        this.pathSaveAndDownload = requireNonNull(pathSaveAndDownload);
    }

    /**
     * Запускает игровой процесс
     */
    public void startGameProcess(String continueName) {
        requireNonNull(continueName);
        out.println(textsMap.get(continueName));
        List<String> qestionList = answersAndQuestions.get(continueName);
        for (int i = 0; i < qestionList.size(); i++) {
            out.printf("%d. %s%n", i + 1, qestionList.get(i));
        }
        if (qestionList.size() != 1) {
            int userInput = scannerGame.nextInt();
            if (userInput > qestionList.size() || userInput < 1) {
                out.println("Введено неверное число");
                startGameProcess(continueName);
            }
            if (userInput == qestionList.size()) {
                tempName = continueName;
            } else {
                continueName = qestionList.get(userInput - 1);
                startGameProcess(continueName);
            }
        } else {
            tempName = null;
        }
    }


    /**
     * Изменяет начальное состояние continueName для продолжения игры
     */
    public void continueGame() {
        if (tempName != null) {
            startGameProcess(tempName);
        } else {
            out.println("Загрузка не выполнена");
        }
    }

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

    public void saveGame() {
        try {
            writeString(get(pathSaveAndDownload), tempName,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            out.println("Ошибка сохранения");
        }
        out.println("Игра сохранена.");
    }

    public String getPathSaveAndDownload() {
        return pathSaveAndDownload;
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

    public Map<String, List<String>> getAnswersAndQuestions() {
        return answersAndQuestions;
    }

    public String getFirstQuest() {
        return firstQuest;
    }

    @Override
    public String toString() {
        return "Quest{, answersAndQuestions=%s}".formatted(answersAndQuestions);
    }

    public String getTempName() {
        return tempName;
    }

}

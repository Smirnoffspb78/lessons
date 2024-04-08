package com.smirnov.project.courseproject2var2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class QuestFile {
    /**
     * Текущее название квеста.
     */
    private String continueName;
    private String tempName;

    /**
     * Путь для сохранения и загрузки названия квеста
     */
    private final String pathSaveAndDownload = "C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/courseproject2var2/Save Progress.txt";

    /**
     * Файл для сохранения и загрузки квеста.
     */
    private final File file = new File(pathSaveAndDownload);
    /**
     * Дефолтный пункт, который добавляется в конец вариантов ответа.
     */
    private static final String RETURN_MENU = "Вернуться в меню.";
    /**
     * Мапа c квестами, где ключи - названия параграфов, значение - Мапа с вариантами ответов,
     * где ключи - номер варианта ответа, значения - Описание варианта ответа.
     */
    private final Map<String, Map<Integer, String>> answersAndQuestions = new LinkedHashMap<>();
    /**
     * Мапа с описанием квеста, где ключи - название параграфов, значения - текстовое описание.
     */
    private final Map<String, String> textsMap = new LinkedHashMap<>();

    /**
     * Сканер для ввода данных в меню.
     */
    private final Scanner scannerMenu = new Scanner(in);
    /**
     * Меню
     */
    private final Menu menu;

    public QuestFile(Menu menu) {
        requireNonNull(menu);
        this.menu = menu;

    }

    void startQuest() {
        String userInput = "";
        while (!userInput.equals("Выйти из игры")) {
            continueName = answersAndQuestions.keySet().stream()
                    .findFirst()
                    .orElse("");
            for (String pointMenu : menu.getMenuMap().keySet()) {
                if (!((pointMenu.equals("Сохранить игру") || pointMenu.equals("Продолжить игру")) && tempName == null
                        || pointMenu.equals("Загрузить игру") && !Files.exists(Path.of(pathSaveAndDownload)))) {
                    out.println(pointMenu);
                }
            }
            userInput = scannerMenu.nextLine();
            menu.execute(userInput, this);
        }
    }

    /**
     * Добавляет параграф в текстовый квест.
     *
     * @param nameParagraph      Имя параграфа
     * @param questionsParagraph Выбор действия
     * @param text               Текстовое описание
     */
    public void addAnswersAndQuestions(String nameParagraph, Map<Integer, String> questionsParagraph, String text) {
        requireNonNull(nameParagraph);
        requireNonNull(text);
        requireNonNull(questionsParagraph);
        questionsParagraph.forEach((number, textNumber) -> {
            requireNonNull(number);
            requireNonNull(textNumber);
        });
        answersAndQuestions.put(nameParagraph, questionsParagraph);
        answersAndQuestions.get(nameParagraph).put(answersAndQuestions.get(nameParagraph).size() + 1, RETURN_MENU);
        textsMap.put(nameParagraph, text);
    }


    /**
     * Запускает игровой процесс
     */
    public void startGameProcess() {
        requireNonNull(continueName);
        Scanner scannerGame = new Scanner(in);
        out.println(textsMap.get(continueName));
        answersAndQuestions.get(continueName).forEach((key, value) -> {
            out.printf("%d. ", key);
            out.println(value);
        });
        if (answersAndQuestions.get(continueName).size() != 1) {
            int userInput = scannerGame.nextInt();
            if (userInput > answersAndQuestions.get(continueName).size() || userInput < 1) {
                throw new IllegalArgumentException("Введенное число должно совпадать с номером одного из пунктов меню.");
            }
            out.println(answersAndQuestions.get(continueName).size());
            if (userInput == answersAndQuestions.get(continueName).size()) {
                tempName = continueName;
            } else {
                continueName = answersAndQuestions.get(continueName).get(userInput);
                startGameProcess();
            }
        } else {
            tempName = null;
        }
    }

    public boolean downloadGame() {

        try {
            continueName = Files.readString(get(pathSaveAndDownload));
            if (textsMap.containsKey(continueName)) {
                return true;
            }
            out.println("Загрузка не удалась");
            return false;
        } catch (IOException e) {
            out.println("Файл отсутствует");
            return false;
        }
    }

    public boolean saveGame() {
        try {
            writeString(get(pathSaveAndDownload), tempName,
                    StandardOpenOption.CREATE //Создать, если нет файла
                    /* StandardOpenOption.APPEND*/); //Дозапись построчная в файле нужна будет при создании имени юзера
        } catch (IOException e) {
            out.println("Ошибка сохранения");
            return false;
        }
        out.println("Игра сохранена.");
        return true;
    }

    /**
     * Изменяет начальное состояние continueName для продолжения игры
     */
    public void continueGame() {
        if (tempName != null) {
            continueName = tempName;
        }
    }

    public Map<String, String> getTextsMap() {
        return textsMap;
    }

    public Map<String, Map<Integer, String>> getAnswersAndQuestions() {
        return answersAndQuestions;
    }

    @Override
    public String toString() {
        return "QuestFile{, answersAndQuestions=%s}".formatted(answersAndQuestions);
    }


}

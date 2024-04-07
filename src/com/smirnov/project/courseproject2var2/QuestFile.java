package com.smirnov.project.courseproject2var2;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class QuestFile {
    /**
     * Текущее название квеста.
     */
    private String continueName;

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

    void startQuest(){
        boolean run;
        for (String pointMenu : menu.getMenuMap().keySet()) {
            if (!((pointMenu.equals("Сохранить игру") || pointMenu.equals("Продолжить игру")) /*&& game.getTempName() == null*/
                    || pointMenu.equals("Загрузить игру") /*&& !game.getPathSaveAndDownload().exists()*/)) {
                out.println(pointMenu);
            }
        }
        String userInput = scannerMenu.nextLine();
        /*continueName = switch (userInput) {
            case "Продолжить игру" -> game.getTempName();
            case "Загрузить игру" -> {
                try {
                    yield Files.readString(get(pathSaveAndDownload));
                } catch (IOException e) {
                    out.println("Файл для загрузки отсутствует");
                    throw new RuntimeException(e);
                }
            }*/

            /*default -> questFile.getAnswersAndQuestions().keySet().stream()
                    .findFirst()
                    .orElse("");*/
          /*  default -> throw new IllegalStateException("Unexpected value: " + userInput);
        };*/
        run = menu.execute(userInput);
        if (!run) {
            startQuest();
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

    public String getReturnMenu() {
        return RETURN_MENU;
    }

    public String getContinueName() {
        return continueName;
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

package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.ContinueGameCommand;
import com.smirnov.project.courseproject2var2.command.DownloadGameCommand;
import com.smirnov.project.courseproject2var2.command.SaveGameCommand;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class Quest {
    /**
     * Текущее название квеста.
     */
    private String continueName;
    private String tempName;

    /**
     * Дефолтный пункт, который добавляется в конец вариантов ответа.
     */
    private static final String RETURN_MENU = "Вернуться в меню.";
    /**
     * Мапа c квестами, где ключи - названия параграфов, значение - Мапа с вариантами ответов,
     * где ключи - номер варианта ответа, значения - Описание варианта ответа.
     */
    private final Map<String, List<String>> answersAndQuestions = new LinkedHashMap<>();
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
    private final Game game;

    public Quest(Menu menu, Game game) {
        requireNonNull(menu);
        requireNonNull(game);
        this.game = game;
        this.menu = menu;

    }

    void startMenu() {
        String userInput = "";
        while (!userInput.equals("Выйти из игры")) {
            continueName = answersAndQuestions.keySet().stream()
                    .findFirst()
                    .orElse("");
            menu.getMenuMap().entrySet().stream()
                    .filter(entry -> !((entry.getValue() instanceof SaveGameCommand || entry.getValue() instanceof ContinueGameCommand) && tempName == null
                            || entry.getValue() instanceof DownloadGameCommand && !Files.exists(Path.of(game.getPathSaveAndDownload()))))
                    .map(Map.Entry::getKey)
                    .forEach(out::println);
            userInput = scannerMenu.nextLine();
            menu.execute(userInput);
        }
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
        questionsParagraph.forEach(Objects::requireNonNull);
        answersAndQuestions.put(nameParagraph, questionsParagraph);
        answersAndQuestions.get(nameParagraph).add(RETURN_MENU);
        textsMap.put(nameParagraph, text);
    }


    public Map<String, String> getTextsMap() {
        return textsMap;
    }

    public Map<String, List<String>> getAnswersAndQuestions() {
        return answersAndQuestions;
    }

    @Override
    public String toString() {
        return "Quest{, answersAndQuestions=%s}".formatted(answersAndQuestions);
    }

    public String getContinueName() {
        return continueName;
    }

    public String getTempName() {
        return tempName;
    }

    public void setContinueName(String continueName) {
        requireNonNull(continueName);
        this.continueName = continueName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public Game getGame() {
        return game;
    }

}

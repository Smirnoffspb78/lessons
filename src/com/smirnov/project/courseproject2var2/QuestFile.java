package com.smirnov.project.courseproject2var2;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class QuestFile {
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

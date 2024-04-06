package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.Command;
import com.smirnov.project.courseproject2var2.command.ExitGameCommand;
import com.smirnov.project.courseproject2var2.command.SaveGameCommand;
import com.smirnov.project.courseproject2var2.command.StartGameCommand;

import java.io.File;
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
 * Игра.
 */
public class Game {

    /**
     * Меню игры.
     */
    private final Menu menu = new Menu();
    /**
     * Текстовый квест.
     */
    private final QuestFile questFile;
    /**
     * Текущее название квеста.
     */
    private String continueName;
    /**
     * Временное название квеста.
     */
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
     * Сканер для ввода данных в меню.
     */
    private final Scanner scannerMenu = new Scanner(in);
    /**
     * Сканер для ввода данных в игровом процессе.
     */
    private final Scanner scannerGame = new Scanner(in);

    /**
     * Конструктор создает игру.
     *
     * @param questFile Текстовый квест.
     */

    public Game(QuestFile questFile) {
        requireNonNull(questFile);
        StartGameCommand startGameCommand = new StartGameCommand(this);
        this.questFile = questFile;
        menu.addCommand("Начать игру", startGameCommand)
                .addCommand("Продолжить игру", startGameCommand)
                .addCommand("Выйти из игры", new ExitGameCommand(this))
                .addCommand("Сохранить игру", new SaveGameCommand(this))
                .addCommand("Загрузить игру", startGameCommand);
    }

    /**
     * Запуск игры.
     */
    public void start() {
        boolean run;
        for (String pointMenu : menu.getMenuMap().keySet()) {
            if (!((pointMenu.equals("Сохранить игру") || pointMenu.equals("Продолжить игру")) && tempName == null
                    || pointMenu.equals("Загрузить игру") && !file.exists())) {
                out.println(pointMenu);
            }
        }
        String userInput = scannerMenu.nextLine();
        continueName = switch (userInput) {
            case "Продолжить игру" -> tempName;
            case "Загрузить игру" -> {
                try {
                    yield Files.readString(get(pathSaveAndDownload));
                } catch (IOException e) {
                    out.println("Файл для загрузки отсутствует");
                    throw new RuntimeException(e);
                }
            }
            default -> questFile.getAnswersAndQuestions().keySet().stream()
                    .findFirst()
                    .orElse("");
        };
        run = menu.execute(userInput);
        if (!run) {
            start();
        }
    }

    /**
     * Запуск игрового процесса.
     *
     * @param numberQuest Наименование квеста.
     */
    public void startGame(String numberQuest) {
        requireNonNull(numberQuest);
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
                start();
            } else {
                startGame(questFile.getAnswersAndQuestions()
                        .get(numberQuest)
                        .get(userInput));
            }
        } else {
            tempName = null;
            start();
        }
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
        try {
            writeString(get(pathSaveAndDownload), tempName,
                    StandardOpenOption.CREATE //Создать, если нет файла
                    /*StandardOpenOption.APPEND*/); //Дозапись построчная в файле нужна будет при создании имени юзера
        } catch (IOException e) {
            out.println("Ошибка сохранения");
            start();
            return false;
        }
        out.println("Игра сохранена.");
        start();
        return true;
    }

    /**
     * Добавление новых пунктов меню.
     *
     * @param name    Название команды.
     * @param command Команда.
     * @return Меню.
     */
    public Menu addPointMenu(String name, Command command) {
        menu.addCommand(name, command);
        return menu;
    }

    public String getContinueName() {
        return continueName;
    }
}

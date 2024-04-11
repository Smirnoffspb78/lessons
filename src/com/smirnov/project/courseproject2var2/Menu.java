package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.Command;
import com.smirnov.project.courseproject2var2.command.ContinueGameCommand;
import com.smirnov.project.courseproject2var2.command.DownloadGameCommand;
import com.smirnov.project.courseproject2var2.command.SaveGameCommand;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

/**
 * Меню.
 */
public class Menu {

    /**
     * Мапа команд, где ключи - названия команд, значения - команды.
     */
    private final Map<String, Command> menuMap = new LinkedHashMap<>();

    /**
     * Добавляет команду в Мапу
     *
     * @param command Команда.
     * @return Меню
     */
    public Menu addCommand(Command command) {
        requireNonNull(command);
        menuMap.putIfAbsent(command.getNameCommand(), command);
        return this;
    }

    /**
     * Выполняет команду при ее наличии в Меню.
     *
     * @param name Имя команды
     */
    public void execute(String name) {
        requireNonNull(name);
        Optional.ofNullable(name)
                .map(menuMap::get)
                .ifPresentOrElse(Command::execute, () -> out.println("Неверная команда. Повторите ввод."));
    }

    public void displayMenu(Game game) {
        String userInput = "";
        Scanner scannerMenu = new Scanner(in);
        while (!userInput.equals("Выйти из игры")) {
            menuMap.entrySet().stream()
                    .filter(entry -> !((entry.getValue() instanceof SaveGameCommand || entry.getValue() instanceof ContinueGameCommand) && game.getTempName() == null
                            || entry.getValue() instanceof DownloadGameCommand && !Files.exists(Path.of(game.getPathSaveAndDownload()))))
                    .map(Map.Entry::getKey)
                    .forEach(out::println);
            userInput = scannerMenu.nextLine();
            execute(userInput);
        }
        scannerMenu.close();
    }

    public Map<String, Command> getMenuMap() {
        return menuMap;
    }
}

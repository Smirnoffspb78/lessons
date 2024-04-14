package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.Command;

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

    private final Scanner scannerMenu = new Scanner(in);

    /**
     * Добавляет команду в Мапу.
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
    private void execute(String name) {
        Optional.ofNullable(name)
                .map(menuMap::get)
                .ifPresentOrElse(Command::execute, () -> out.println("Неверная команда. Повторите ввод."));
    }

    /**
     * Выводит меню в консоль.
     */
    public void displayMenu() {
        String userInput = "";
        while (!userInput.equals("Выйти из игры")) {
            menuMap.values().stream()
                    .filter(Command::isDisplay)
                    .forEach(command -> out.println(command.getNameCommand()));
            userInput = scannerMenu.nextLine();
            execute(userInput);
        }
    }
}

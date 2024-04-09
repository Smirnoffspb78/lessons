package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.Command;

import java.util.LinkedHashMap;
import java.util.Map;

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

    Game game;

    /**
     * Добавляет команду в Мапу
     *
     * @param command Команда.
     * @return Меню
     */
    public Menu addCommand(Command command) {
        requireNonNull(command);
        if (menuMap.containsKey(command.getNameCommand())) {
            return this;
        }
        menuMap.put(command.getNameCommand(), command);
        return this;
    }

    public Menu() {

    }

    /**
     * Выполняет команду при ее наличии в Меню.
     *
     * @param name Имя команды
     * @return true/false - Если команда имеется в Меню/отсутствует в меню
     */
    public boolean execute(String name) {
        requireNonNull(name);
        if (menuMap.containsKey(name)) {
            menuMap.get(name).execute();
            return true;
        } else {
            out.println("Неверная команда. Повторите ввод.");
            return false;
        }
    }

    public Map<String, Command> getMenuMap() {
        return menuMap;
    }
}

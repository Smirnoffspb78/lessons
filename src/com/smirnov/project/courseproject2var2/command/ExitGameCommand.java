package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

import static java.lang.System.out;

/**
 * Команда для выхода из игры.
 */
public class ExitGameCommand extends Command {

    /**
     * Конструктор создает команду выхода из игры.
     *
     * @param nameCommand наименование команды
     */
    public ExitGameCommand(String nameCommand, Quest quest) {
        super(nameCommand, quest);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.println("До новых встреч!");
    }
}

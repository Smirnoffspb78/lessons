package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

import static java.lang.System.out;

/**
 * Команда для выхода из игры.
 */
public class ExitGameCommand extends Command {

    /**
     * Конструктор создает команду выхода из игры.
     *
     * @param nameCommand наименование команды
     * @param game        Игровой процесс
     */
    public ExitGameCommand(String nameCommand, Game game) {
        super(nameCommand, game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.println("До новых встреч!");
    }
}

package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для выхода из игры.
 */
public class ExitGameCommand extends Command {

    /**
     * Конструктор создает команду выхода из игры.
     *
     * @param nameCommand наименование команды
     */
    public ExitGameCommand(String nameCommand) {
        super(nameCommand);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute(Game game) {
        game.exitGame();
    }
}

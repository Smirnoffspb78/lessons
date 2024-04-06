package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для выхода из игры.
 */
public class ExitGameCommand extends Command {

    /**
     * Конструктор создает команду выхода из игры.
     *
     * @param game Игра
     */
    public ExitGameCommand(Game game) {
        super(game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.exitGame();
    }
}

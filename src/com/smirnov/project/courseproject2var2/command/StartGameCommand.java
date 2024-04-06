package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для запуска игрового процесса.
 */
public class StartGameCommand extends Command {

    /**
     * Конструктор создает команду для запуска игрового процесса.
     *
     * @param game Игра
     */
    public StartGameCommand(Game game) {
        super(game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.startGame(game.getContinueName());
    }
}

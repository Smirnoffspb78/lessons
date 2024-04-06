package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда сохранения игры.
 */
public class SaveGameCommand extends Command {

    /**
     * Конструктор создает команду для сохранения игры.
     *
     * @param game Игра
     */
    public SaveGameCommand(Game game) {
        super(game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.saveGame();
    }
}

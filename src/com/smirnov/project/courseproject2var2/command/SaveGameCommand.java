package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда сохранения игры.
 */
public class SaveGameCommand extends Command {

    /**
     * Конструктор создает команду для сохранения игры.
     *
     * @param nameCommand Наименование команды
     * @param game        Игровой процесс
     */
    public SaveGameCommand(String nameCommand, Game game) {
        super(nameCommand, game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.saveGame();
    }

    /**
     * Проверяет возможность вывода на экран
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return game.getTempName() != null;
    }
}

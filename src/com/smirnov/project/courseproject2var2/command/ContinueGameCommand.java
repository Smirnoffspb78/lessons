package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для возобновления игрового процесса.
 */
public class ContinueGameCommand extends Command {


    /**
     * Конструктор создает команду для возобновления игрового процесса.
     *
     * @param nameCommand Наименование команды
     * @param game        Игровой процесс
     */
    public ContinueGameCommand(String nameCommand, Game game) {
        super(nameCommand, game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.continueGame();
    }

    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return game.getTempName() != null;
    }
}

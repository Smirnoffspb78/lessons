package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для запуска игрового процесса.
 */
public class StartGameCommand extends Command {


    /**
     * Конструктор создает команду для запуска игрового процесса.
     *
     * @param nameCommand Наименование команды
     * @param game        Игровой процесс
     */
    public StartGameCommand(String nameCommand, Game game) {
        super(nameCommand, game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.startGameProcess(game.getFirstQuest());
    }
}

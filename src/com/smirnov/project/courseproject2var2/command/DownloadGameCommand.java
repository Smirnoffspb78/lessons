package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.Game;

/**
 * Команда для загрузки игрового процесса.
 */
public class DownloadGameCommand extends Command {

    /**
     * Конструктор создает команду для загрузки игрового процесса.
     *
     * @param nameCommand Наименование команды
     * @param game        Игровой процесс
     */
    public DownloadGameCommand(String nameCommand, Game game) {
        super(nameCommand, game);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        game.downloadGame();
    }
}

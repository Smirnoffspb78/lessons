package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.Game;

import java.nio.file.Files;
import java.nio.file.Path;

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

    /**
     * Проверяет возможность вывода на экран
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return Files.exists(Path.of(game.getPathSaveAndDownload()));
    }
}

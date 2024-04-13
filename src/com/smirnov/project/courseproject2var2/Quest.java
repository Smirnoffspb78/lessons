package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.*;

import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class Quest {

    /**
     * Меню
     */
    private final Menu menu;
    private final Game game;

    public Quest(Menu menu, Game game) {
        this.game = requireNonNull(game);
        this.menu = requireNonNull(menu);
        menu.addCommand(new StartGameCommand("Начать игру", game))
                .addCommand(new ContinueGameCommand("Продолжить игру", game))
                .addCommand(new ExitGameCommand("Выйти из игры", game))
                .addCommand(new SaveGameCommand("Сохранить игру", game))
                .addCommand(new DownloadGameCommand("Загрузить игру", game));
    }

    public void startMenu() {
        menu.displayMenu(game);
    }

}

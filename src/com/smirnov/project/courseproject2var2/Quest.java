package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.*;

import static java.util.Objects.requireNonNull;

/**
 * Файл с текстовым квестом.
 */
public class Quest {

    /**
     * Меню.
     */
    private final Menu menu;

    /**
     * Конструктор создает квест.
     *
     * @param menu Меню
     * @param game Игровой процесс
     */
    public Quest(Menu menu, Game game) {
        this.menu = requireNonNull(menu);
        menu.addCommand(new StartGameCommand("Начать игру", game))
                .addCommand(new ContinueGameCommand("Продолжить игру", game))
                .addCommand(new ExitGameCommand("Выйти из игры", game))
                .addCommand(new SaveGameCommand("Сохранить игру", game))
                .addCommand(new DownloadGameCommand("Загрузить игру", game));
    }

    /**
     * Запускает меню.
     */
    public void startMenu() {
        menu.displayMenu();
    }

}

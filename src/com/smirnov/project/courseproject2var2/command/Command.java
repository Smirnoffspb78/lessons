package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

import static java.util.Objects.requireNonNull;

/**
 * Команда.
 */
public abstract class Command {
    /**
     * Игра.
     */
    Game game;

    /**
     * Конструктор создает команду для игры.
     *
     * @param game Игра
     */
    Command(Game game) {
        requireNonNull(game);
        this.game = game;
    }

    /**
     * Выполнить команду.
     */
    public abstract void execute();
}


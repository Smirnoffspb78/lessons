package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Game;

import static java.util.Objects.requireNonNull;

/**
 * Команда.
 */
public abstract class Command {

    /**
     * Наименование команды.
     */
    private final String nameCommand;
    /**
     * Игровой процесс
     */
    protected final Game game;

    /**
     * Конструктор создает команду для игры.
     *
     * @param commandName Название команды
     * @param game        Игровой процесс
     */
    Command(String commandName, Game game) {
        this.nameCommand = requireNonNull(commandName);
        this.game = requireNonNull(game);

    }

    /**
     * Выполнить команду.
     */
    public abstract void execute();

    public String getNameCommand() {
        return nameCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Command command)) {
            return false;
        }

        return nameCommand.equals(command.nameCommand);
    }

    @Override
    public int hashCode() {
        return nameCommand.hashCode();
    }
}


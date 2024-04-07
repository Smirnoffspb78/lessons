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
    String nameCommand;

    /**
     * Конструктор создает команду для игры.
     *
     * @param nameCommand Название команды
     */
    Command(String nameCommand) {
        requireNonNull(nameCommand);
        this.nameCommand = nameCommand;
    }

    /**
     * Выполнить команду.
     */
    public abstract void execute(Game game);

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


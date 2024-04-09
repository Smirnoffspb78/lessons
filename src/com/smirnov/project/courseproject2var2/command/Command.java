package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Команда.
 */
public abstract class Command {

    /**
     * Наименование команды.
     */
    private final String nameCommand;
    Quest quest;

    /**
     * Конструктор создает команду для игры.
     *
     * @param nameCommand Название команды
     */
    Command(String nameCommand, Quest quest) {
        requireNonNull(nameCommand);
        Objects.requireNonNull(quest);
        this.nameCommand = nameCommand;
        this.quest = quest;
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


package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

/**
 * Команда сохранения игры.
 */
public class SaveGameCommand extends Command {

    /**
     * Конструктор создает команду для сохранения игры.
     *
     * @param nameCommand Наименование команды
     */
    public SaveGameCommand(String nameCommand, Quest quest) {
        super(nameCommand, quest);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        quest.getGame().saveGame(quest);
    }
}

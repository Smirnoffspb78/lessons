package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

/**
 * Команда для запуска игрового процесса.
 */
public class StartGameCommand extends Command {


    /**
     * Конструктор создает команду для запуска игрового процесса.
     *
     * @param nameCommand Наименование команды
     */
    public StartGameCommand(String nameCommand, Quest quest) {
        super(nameCommand, quest);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        quest.getGame().startGameProcess(quest);
    }
}

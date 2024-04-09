package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

/**
 * Команда для возобновления игрового процесса.
 */
public class ContinueGameCommand extends Command {


    /**
     * Конструктор создает команду для возобновления игрового процесса
     *
     * @param nameCommand Наименование команды
     * @param quest       Квест
     */
    public ContinueGameCommand(String nameCommand, Quest quest) {
        super(nameCommand, quest);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        quest.getGame().continueGame(quest);
    }
}

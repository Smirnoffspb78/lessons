package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.QuestFile;

/**
 * Команда для запуска игрового процесса.
 */
public class StartGameCommand extends Command {


    /**
     * Конструктор создает команду для запуска игрового процесса.
     *
     * @param nameCommand Наименование команды
     */
    public StartGameCommand(String nameCommand) {
        super(nameCommand);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute(QuestFile questFile) {
        questFile.startGameProcess();
    }
}

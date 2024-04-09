package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.Quest;

/**
 * Команда для загрузки игрового процесса.
 */
public class DownloadGameCommand extends Command {

    /**
     * Конструктор создает команду для загрузки игрового процесса.
     *
     * @param nameCommand Наименование команды
     * @param quest       Квест
     */
    public DownloadGameCommand(String nameCommand, Quest quest) {
        super(nameCommand, quest);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        if (quest.getGame().downloadGame(quest)) {
            quest.getGame().startGameProcess(quest);
        }
    }
}

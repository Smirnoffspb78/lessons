package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.Quest;

public class DownloadGameCommand extends Command {

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

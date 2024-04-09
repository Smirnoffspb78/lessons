package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.Quest;

public class ContinueGameCommand extends Command {


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

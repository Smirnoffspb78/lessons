package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.QuestFile;

public class ContinueGameCommand extends Command {

    public ContinueGameCommand(String nameCommand) {
        super(nameCommand);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute(QuestFile questFile) {
        questFile.continueGame();
        questFile.startGameProcess();
    }
}

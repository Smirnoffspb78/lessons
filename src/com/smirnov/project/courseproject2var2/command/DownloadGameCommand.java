package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.QuestFile;

import static java.util.Objects.requireNonNull;

public class DownloadGameCommand extends Command {


    public DownloadGameCommand(String nameCommand) {
        super(nameCommand);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute(QuestFile questFile) {
        requireNonNull(questFile);
        if (questFile.downloadGame()) {
            questFile.startGameProcess();
        }
    }
}

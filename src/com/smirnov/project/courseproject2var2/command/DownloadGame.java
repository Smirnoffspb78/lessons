package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.QuestFile;

import static java.util.Objects.requireNonNull;

public class DownloadGame extends Command {


    public DownloadGame(String nameCommand) {
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

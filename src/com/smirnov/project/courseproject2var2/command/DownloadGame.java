package com.smirnov.project.courseproject2var2.command;


import com.smirnov.project.courseproject2var2.QuestFile;

import java.io.IOException;
import java.nio.file.Files;

import static java.lang.System.out;
import static java.nio.file.Paths.get;
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
        try {
            Files.readString(get(questFile.getPathSaveAndDownload()));
        } catch (IOException e) {
            out.println("Файл отсутствует");
            throw new RuntimeException(e);
        }

    }
}

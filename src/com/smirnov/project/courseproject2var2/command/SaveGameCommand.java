package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.QuestFile;

import java.io.IOException;
import java.nio.file.StandardOpenOption;

import static java.lang.System.out;
import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

/**
 * Команда сохранения игры.
 */
public class SaveGameCommand extends Command {

    /**
     * Конструктор создает команду для сохранения игры.
     *
     * @param nameCommand Наименование команды
     */
    public SaveGameCommand(String nameCommand) {
        super(nameCommand);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute(QuestFile questFile) {
        requireNonNull(questFile);
        try {
            writeString(get(questFile.getPathSaveAndDownload()), questFile.getTempName(),
                    StandardOpenOption.CREATE //Создать, если нет файла
                    /*StandardOpenOption.APPEND*/); //Дозапись построчная в файле нужна будет при создании имени юзера
        } catch (IOException e) {
            out.println("Ошибка сохранения");
            throw new RuntimeException();
        }
        out.println("Игра сохранена.");
    }
}

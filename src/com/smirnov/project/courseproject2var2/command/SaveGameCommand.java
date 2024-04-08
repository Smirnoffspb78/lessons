package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.QuestFile;

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
        questFile.saveGame();
    }
}

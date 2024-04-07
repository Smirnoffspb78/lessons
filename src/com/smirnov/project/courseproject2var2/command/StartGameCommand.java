package com.smirnov.project.courseproject2var2.command;

import com.smirnov.project.courseproject2var2.QuestFile;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

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
        Scanner scannerGame = new Scanner(in);
        requireNonNull(questFile);
        String numberQuest=questFile.getContinueName();
        out.println(questFile.getTextsMap().get(numberQuest));
        questFile.getAnswersAndQuestions().get(numberQuest).forEach((key, value) -> {
            out.printf("%d. ", key);
            out.println(value);
        });
        if (questFile.getAnswersAndQuestions().get(numberQuest).size() != 1) {
            int userInput = scannerGame.nextInt();
            if (userInput>questFile.getAnswersAndQuestions().get(numberQuest).size() || userInput<1){
                throw new IllegalArgumentException("Введенное число должно совпадать с номером одного из пунктов меню.");
            }
            out.println(questFile.getAnswersAndQuestions().get(numberQuest).size());
            if (userInput == questFile.getAnswersAndQuestions().get(numberQuest).size()) {
                questFile.setTempName(numberQuest);
            } else {
                questFile.setContinueName(questFile.getAnswersAndQuestions().get(numberQuest).get(userInput));
                execute(questFile);
            }
        } else {
            questFile.setTempName(null);
        }
    }
}

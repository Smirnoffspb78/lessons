package com.smirnov.project.lesson08.homework8.task1;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Класс создает группу альпинистов из ссылок на объекты Climber.
 * Класс реализует методы записи в группу новых альпинистов и проверку
 * свободных мест в созданной группе.
 */
public class GroupOfClimber {
    private static final Logger LOGGER = Logger.getLogger(GroupOfClimber.class.getName());
    /**
     * Проверят наличие свободных мест в созданной группе.
     */
    private boolean checkSet;
    /**
     * Определяет количество человек в группе.
     */
    private int numberClimberInGroup;
    /**
     * Массив для записи альпинистов.
     *
     * @see Climber
     */
    private Climber[] climbers;
    /**
     * Используется для передачи ссылки на объект класса Mountain
     * для привязки группы альпинистов к конкретной горе.
     *
     * @see Mountain
     */
    private Mountain mountain;
    /**
     * Указатель номера текущей записи.
     */
    private int counterClimber;
    /**
     * Массив для хранение только имен группы
     */
    private String[] arrNameClimber;
    private static final Climber defaultClimber =
            new Climber("DefaultName", "DefaultAddress");

    private GroupOfClimber() {
    }

    /**
     * Конструктор, который создает группу альпинистов с парамтетрами.
     *
     * @param numberClimberInGroup Размер группы
     * @param mountain             Гора, на которую восходит группа альпинистов
     */
    GroupOfClimber(int numberClimberInGroup,
                   Mountain mountain) {
        if (numberClimberInGroup < 1) {
            this.numberClimberInGroup = 0;
            LOGGER.warning("Количество альпинистов не может быть меньше %d. Группа не создана".formatted(numberClimberInGroup));
        } else {
            this.numberClimberInGroup = numberClimberInGroup;
        }
        climbers = new Climber[numberClimberInGroup];
        Arrays.fill(climbers, defaultClimber);
        this.mountain = mountain;
        checkSet = numberClimberInGroup != 0;
        arrNameClimber = new String[numberClimberInGroup];
        Arrays.fill(arrNameClimber, defaultClimber.getName());
    }

    /**
     * Метод осуществляет запись альпинистов в группу, если запись в группу свободна.
     *
     * @param climber Ссылка на объект класса Climber
     * @see Climber
     */
    public void addClimberInGroup(Climber climber) {
        if (checkSet) {
            climbers[counterClimber] = climber;
            arrNameClimber[counterClimber] = climbers[counterClimber].getName();
            counterClimber++;
        } else {
            LOGGER.info("Эта группа уже укомлектована");
        }
        if (counterClimber == numberClimberInGroup) {
            checkSet = false;
        }
    }

    /**
     * Метод выводит информацию о записанных в группу альпинистах.
     */
    public void printNameClimbers() {
        LOGGER.info(Arrays.toString(arrNameClimber));
    }

    public boolean getCheckSet() {
        return checkSet;
    }
}

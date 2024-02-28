package com.smirnov.project.lesson08.homework8.task1;

/**
 * Группа альпинистов для восхождения на гору
 */
public class GroupOfClimber {
    /**
     * Указывает открыт ли набор в группу
     */
    private boolean isRecruitOpened;
    /**
     * Количество человек в группе.
     */
    private final int numberClimberInGroup;
    /**
     * Массив для записи альпинистов.
     *
     * @see Climber
     */
    private Climber[] climbers;

    /**
     * Гора
     *
     * @see Mountain
     */
    private Mountain mountain;
    /**
     * Указатель номера текущей записи.
     */
    private int counterClimber;

    /**
     * Конструктор, который создает группу альпинистов с парамтетрами.
     *
     * @param numberClimberInGroup Размер группы
     * @param mountain             Гора, на которую восходит группа альпинистов
     */
    public GroupOfClimber(int numberClimberInGroup,
                          Mountain mountain) {
        if (numberClimberInGroup < 1) {
            throw new IllegalArgumentException("Количество альпинистов не может быть меньше %d. Группа не создана".formatted(numberClimberInGroup));
        } else {
            this.numberClimberInGroup = numberClimberInGroup;
        }
        climbers = new Climber[numberClimberInGroup];
        this.mountain = mountain;
        isRecruitOpened = true;
    }

    /**
     * Метод осуществляет запись альпинистов в группу, если запись в группу свободна.
     *
     * @param climber Ссылка на объект класса Climber
     * @see Climber
     */
    public boolean addClimberInGroup(Climber climber) {
        if (isRecruitOpened) {
            climbers[counterClimber] = climber;
            if (counterClimber++ == numberClimberInGroup) {
                isRecruitOpened = false;
            }
            return true;
        } else {
            return false;
        }
    }

    public int getCounterClimber() {
        return counterClimber;
    }

    public Climber[] getClimbers() {
        return climbers.clone();
    }

    public int getNumberClimberInGroup() {
        return numberClimberInGroup;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public boolean isRecruitOpened() {
        return isRecruitOpened;
    }
}

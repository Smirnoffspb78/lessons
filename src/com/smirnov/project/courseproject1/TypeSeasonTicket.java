package com.smirnov.project.courseproject1;

import static com.smirnov.project.courseproject1.Fitness.*;

/**
 * Типы абонементов.
 */
public enum TypeSeasonTicket {
    /**
     * Разовый абонемент.
     */
    ONE_TIME(8, 22, new Fitness[]{GYM, SWIMMING_POOL}),
    /**
     * Дневной абонемент.
     */
    DAY_TIME(8, 16, new Fitness[]{GYM, GROUP_CLASSES}),
    /**
     * Полный абонемент.
     */
    FULL_TIME(8, 22, new Fitness[]{GYM, SWIMMING_POOL, GROUP_CLASSES});

    /**
     * Начало посещения.
     */
    private final int beginTime;
    /**
     * Окончание посещения.
     */
    private final int endTime;
    /**
     * Типы секций, доступные для посещений.
     */
    private final Fitness[] typeFitness;

    /**
     * Конструктор задает время посещения и типы секций для абонемента.
     *
     * @param beginTime   Начало посещения
     * @param endTime     Окончание посещения
     * @param typeFitness Тип секции
     */
    TypeSeasonTicket(int beginTime, int endTime, Fitness[] typeFitness) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.typeFitness = typeFitness;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Fitness[] getTypeFitness() {
        return typeFitness.clone();
    }
}

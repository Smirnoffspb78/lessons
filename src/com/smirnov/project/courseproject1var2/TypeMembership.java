package com.smirnov.project.courseproject1var2;

import java.time.LocalTime;

import static com.smirnov.project.courseproject1var2.TypeFitness.*;

/**
 * Типы абонементов.
 */
public enum TypeMembership {
    /**
     * Разовый абонемент.
     */
    ONE_TIME(LocalTime.of(8, 0), LocalTime.of(23, 0), new TypeFitness[]{GYM, SWIMMING_POOL}),
    /**
     * Дневной абонемент.
     */
    DAY_TIME(LocalTime.of(8, 0), LocalTime.of(16, 0), new TypeFitness[]{GYM, GROUP_CLASSES}),
    /**
     * Полный абонемент.
     */
    FULL_TIME(LocalTime.of(8, 0), LocalTime.of(23, 0), new TypeFitness[]{GYM, SWIMMING_POOL, GROUP_CLASSES});

    /**
     * Начало посещения.
     */
    private final LocalTime beginTime;
    /**
     * Окончание посещения.
     */
    private final LocalTime endTime;
    /**
     * Типы секций, доступные для посещений.
     */
    private final TypeFitness[] typeFitness;

    /**
     * Конструктор задает время посещения и типы секций для абонемента.
     *
     * @param beginTime   Начало посещения
     * @param endTime     Окончание посещения
     * @param typeFitness Тип секции
     */
    TypeMembership(LocalTime beginTime, LocalTime endTime, TypeFitness[] typeFitness) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.typeFitness = typeFitness;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public TypeFitness[] getTypeFitness() {
        return typeFitness.clone();
    }
}

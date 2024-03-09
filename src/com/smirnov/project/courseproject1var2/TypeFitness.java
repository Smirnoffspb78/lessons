package com.smirnov.project.courseproject1var2;

/**
 * Типы фитнесов.
 */
public enum TypeFitness {
    GYM("Спортивный зал"),
    SWIMMING_POOL("Бассейн"),
    GROUP_CLASSES("Групповые занятия");

    /**
     * Наименование секции фитнеса.
     */
    private final String name;

    /**
     * Конструктор создает секцию фитнеса.
     *
     * @param name Наименование секции фитнеса
     */
    TypeFitness(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

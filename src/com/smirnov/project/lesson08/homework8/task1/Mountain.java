package com.smirnov.project.lesson08.homework8.task1;

/**
 * Класс описывает объект Mountain
 */
public class Mountain {
    /**
     * name -  Наименование горы
     */
    private String name;
    /**
     * country - Наименование страны, где находится гора.
     */
    private String country;
    /**
     * height - Высота горы.
     */
    private double height;
    private static final int MIN_LENGTH_NAME_AND_COUNTRY = 4;
    private static final int MIN_HEIGHT_MOUNTAIN = 100;

    private Mountain() {
    }

    /**
     * Конструктор, который создает гору с параметрами.
     *
     * @param name    Название горы
     * @param country Название страны
     * @param height  Высота горы
     * @throws IllegalArgumentException Если высота горы меньше 100.
     *                                  Если название горы или страны null или название страны или горы меньше 4 без пробелов
     */
    Mountain(String name, String country, double height) {
        if (name == null || country == null || name.replaceAll(" ", "").length() < MIN_LENGTH_NAME_AND_COUNTRY
                || country.replaceAll(" ", "").length() < MIN_LENGTH_NAME_AND_COUNTRY) {
            throw new IllegalArgumentException("Наименование страны и горы не должно быть null или иметь менее %d символов в наименовании.".formatted(MIN_LENGTH_NAME_AND_COUNTRY));
        } else if (height < MIN_HEIGHT_MOUNTAIN) {
            throw new IllegalArgumentException("Высота горы не быть менее %d метров".formatted(MIN_HEIGHT_MOUNTAIN));
        }
        this.name = name.trim().toUpperCase();
        this.country = country.trim().toUpperCase();
        this.height = height;
    }
}

package com.smirnov.project.lesson08.homework8.task1;

/**
 * Гора.
 */
public class Mountain {
    /**
     * Наименование горы.
     */
    private String name;
    /**
     * Наименование страны, где находится гора.
     */
    private String country;
    /**
     * Высота горы, [м].
     */
    private double height;
    private static final int MIN_LENGTH_NAME_AND_COUNTRY = 4;
    private static final int MIN_HEIGHT_MOUNTAIN = 100;

    /**
     * Конструктор, который создает гору с параметрами.
     *
     * @param name    Название горы
     * @param country Название страны
     * @param height  Высота горы
     * @throws IllegalArgumentException Если высота горы меньше необходимого значения.
     *                                  Если название горы или страны null или название страны или горы необходимого значения
     */
    Mountain(String name, String country, double height) {
        if (name == null || name.isBlank() || name.length() < MIN_LENGTH_NAME_AND_COUNTRY) {
            throw new IllegalArgumentException("Наименование горы не должно быть null или иметь менее %d символов в наименовании.".formatted(MIN_LENGTH_NAME_AND_COUNTRY));
        } else if (country == null || country.isBlank() || country.length() < MIN_LENGTH_NAME_AND_COUNTRY) {
            throw new IllegalArgumentException("Наименование страны не должно быть null или иметь менее %d символов в наименовании.".formatted(MIN_LENGTH_NAME_AND_COUNTRY));
        }
        else if (height < MIN_HEIGHT_MOUNTAIN) {
            throw new IllegalArgumentException("Высота горы не должна быть менее %d метров".formatted(MIN_HEIGHT_MOUNTAIN));
        }
        this.name = name.trim().toUpperCase();
        this.country = country.trim().toUpperCase();
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getHeight() {
        return height;
    }
}

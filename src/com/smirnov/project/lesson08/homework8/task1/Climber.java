package com.smirnov.project.lesson08.homework8.task1;

/**
 * Класс описывает объект Climber, который харауктеризует альпиниста.
 */
public class Climber {
    /**
     * Имя альпиниста.
     */
    private String name;
    /**
     * Адрес альпинсита.
     */
    private String address;
    private static final int MIN_LENGTH_NAME = 3;
    private static final int MIN_LENGTH_ADDRESS = 5;

    private Climber() {
    }

    /**
     * Конструктор, который принимает характеристики альпинста.
     *
     * @param name    Имя альпиниста
     * @param address Адрес альпиниста
     * @throws IllegalArgumentException Если один из параметров коснтруктора null или
     *                                  длина имени меньше 3 или длина адреса меньше 5 без пробелов.
     */
    public Climber(String name, String address) {
        if (name == null || address == null ||
                name.replaceAll(" ", "").length() < MIN_LENGTH_NAME || address.replaceAll(" ", "").length() < MIN_LENGTH_ADDRESS) {
            throw new IllegalArgumentException("Имя и адрес не должны быть null. Имя не должно быть короче %d символов. Адрес не должен быть короче %d символов.".formatted(MIN_LENGTH_NAME, MIN_LENGTH_ADDRESS));
        }
        this.name = name.trim().toUpperCase();
        this.address = address.trim().toUpperCase();
    }

    public String getName() {
        return name;
    }
}

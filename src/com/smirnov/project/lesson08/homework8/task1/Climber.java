package com.smirnov.project.lesson08.homework8.task1;

/**
 * Альпинист
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

    /**
     * Конструктор, который принимает характеристики альпинста.
     *
     * @param name    Имя альпиниста
     * @param address Адрес альпиниста
     * @throws IllegalArgumentException Если один из параметров коснтруктора null или
     *                                  имя не соотвествует необходимой длине.
     */
    public Climber(String name, String address) {
        if (name == null || name.isBlank() || name.length() < MIN_LENGTH_NAME) {
            throw new IllegalArgumentException("Имя не должно быть null и быть короче %d символов.".formatted(MIN_LENGTH_NAME));
        }
        setAddress(address);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank() || address.length() < MIN_LENGTH_ADDRESS) {
            throw new IllegalArgumentException("Адрес не должен быть null и быть короче %d символов.".formatted(MIN_LENGTH_ADDRESS));
        }
        this.address = address;
    }


    public String getAddress() {
        return address;
    }
}

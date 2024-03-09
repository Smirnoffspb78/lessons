package com.smirnov.project.courseproject1var2;

import java.time.Year;

/**
 * Владелец абонемента.
 */
public class OwnerMembership {
    /**
     * Год рождения.
     */
    private final int yearBorn;
    /**
     * Имя.
     */
    private final String name;
    /**
     * Фамилия.
     */
    private String surname;

    /**
     * Конструктор создает владельца абонемента.
     *
     * @param name     Имя
     * @param surname  Фамилия
     * @param yearBorn Год рождения
     */
    public OwnerMembership(String name, String surname, int yearBorn) {
        if (name == null || surname == null) {
            throw new NullPointerException("name и surname не должны быть null");
        }
        if (name.isBlank() || surname.isBlank() || yearBorn > Year.now().getValue()) {
            throw new IllegalArgumentException("\nname и surname должны иметь хотя бы одни символ.\nyearBorn не может быть позднее текущего года.");
        }
        this.name = name;
        this.surname = surname;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) {
            throw new NullPointerException("surname не должно быть null.");
        } else if (surname.isBlank()) {
            throw new IllegalArgumentException("surname должно иметь хотя бы одни символ.");
        }
        this.surname = surname;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    @Override
    public String toString() {
        return
                "%s %s".formatted(name, surname);
    }
}

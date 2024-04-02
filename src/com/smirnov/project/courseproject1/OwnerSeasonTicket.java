package com.smirnov.project.courseproject1;

import java.time.Year;

/**
 * Владелец абонемента.
 */
public class OwnerSeasonTicket {
    /**
     * Год рождения.
     */
    private final int yearBorn;
    /**
     * Имя.
     */
    private String name;
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
     * @throws IllegalArgumentException Если name и surname null или пустые. Если yearBorn больше текущего года
     */
    public OwnerSeasonTicket(String name, String surname, int yearBorn) {
        if (name == null || name.isBlank() || surname == null || surname.isBlank() || yearBorn > Year.now().getValue()) {
            throw new IllegalArgumentException("\nname и surname не должны быть null и иметь хотя бы одни символ.\nyearBorn не может быть позднее текущего года.");
        }
        this.name = name;
        this.surname = surname;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name не должно быть null и иметь хотя бы одни символ.");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("surname не должно быть null и иметь хотя бы одни символ.");
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

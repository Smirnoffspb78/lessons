package com.smirnov.project.courseproject1;

import java.time.LocalDate;

import static com.smirnov.project.courseproject1.TypeSeasonTicket.*;

/**
 * Абонемент.
 */
public class SeasonTicket {
    /**
     * Номер абонемента.
     */
    private int number=1;
    /**
     * Счетчик абонементов.
     */
    private static int id=1;
    /**
     * Дата начала действия абонемента.
     */
    private final LocalDate dateOfRegistration = LocalDate.now();
    /**
     * Дата окончания действия абонемента.
     */
    private LocalDate dateEnding;
    /**
     * Владелец абонемента.
     */
    private OwnerSeasonTicket ownerSeasonTicket;
    /**
     * Тип абонемента.
     */
    private TypeSeasonTicket typeSeasonTicket;

    /**
     * Конструктор создает разовый абонемент.
     *
     * @param ownerSeasonTicket Владелец абонемента
     * @throws IllegalArgumentException Если ownerSeasonTicket=null. Если number отрицательный или 0
     */
    public SeasonTicket(OwnerSeasonTicket ownerSeasonTicket) {
        if (ownerSeasonTicket == null || number < 1) {
            throw new IllegalArgumentException("ownerSeasonTicket не может быть null.\nnumber должен быть положительным");
        }
        typeSeasonTicket = ONE_TIME;
        number=id++;
        this.ownerSeasonTicket = ownerSeasonTicket;
        dateEnding = LocalDate.now().plusDays(1);
    }

    /**
     * Конструктор создает не разовый абонемент.
     *
     * @param number            Номер абонемента
     * @param dateEnding        Дата окончания действия абонемента
     * @param ownerSeasonTicket Владелец абонемента
     * @param typeSeasonTicket  Тип абонемента
     * @throws IllegalArgumentException Если typeSeasonTicket null или ONE_TIME. Если dateOfRegistration не позднее dateOfRegistration
     */
    public SeasonTicket(LocalDate dateEnding, OwnerSeasonTicket ownerSeasonTicket, TypeSeasonTicket typeSeasonTicket) {
        this(ownerSeasonTicket);
        if (typeSeasonTicket == null || typeSeasonTicket == ONE_TIME || !dateEnding.isAfter(dateOfRegistration)) {
            throw new IllegalArgumentException("typeSeasonTicket не должен быть null, не должен быть ONE_TIME.\n dateEnding должна быть позже, чем dateOfRegistration");
        }
        this.dateEnding = dateEnding;
        this.typeSeasonTicket = typeSeasonTicket;
        number=id++;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public OwnerSeasonTicket getOwnerSeasonTicket() {
        return ownerSeasonTicket;
    }

    public TypeSeasonTicket getTypeSeasonTicket() {
        return typeSeasonTicket;
    }

    public void setOwnerSeasonTicket(OwnerSeasonTicket ownerSeasonTicket) {
        if (ownerSeasonTicket == null) {
            throw new IllegalArgumentException("ownerSeasonTicket не может быть null");
        }
        this.ownerSeasonTicket = ownerSeasonTicket;
    }

    @Override
    public String toString() {
        return "%s".formatted(ownerSeasonTicket);
    }
}

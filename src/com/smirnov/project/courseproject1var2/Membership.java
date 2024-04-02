package com.smirnov.project.courseproject1var2;

import java.time.LocalDate;

import static com.smirnov.project.courseproject1var2.TypeMembership.ONE_TIME;

/**
 * Абонемент.
 */
public class Membership {
    /**
     * Счетчик абонементов.
     */
    private static int id;
    /**
     * Номер абонемента.
     */
    private final int number;

    /**
     * Дата начала действия абонемента.
     */
    private final LocalDate dateOfRegistration = LocalDate.now();
    /**
     * Дата окончания действия абонемента.
     */
    private final LocalDate dateEnding;
    /**
     * Тип абонемента.
     */
    private final TypeMembership typeMembership;

    /**
     * Владелец абонемента.
     */
    private OwnerMembership ownerMembership;

    /**
     * Конструктор создает абонемент.
     *
     * @param dateEnding      Дата окончания действия абонемента
     * @param ownerMembership Владелец абонемента
     * @param typeMembership  Тип абонемента
     */
    public Membership(LocalDate dateEnding, OwnerMembership ownerMembership, TypeMembership typeMembership) {
        if (typeMembership == null || ownerMembership == null) {
            throw new NullPointerException("typeMembership и ownerMembership не должен быть null.");
        }
        if (!dateEnding.isAfter(dateOfRegistration)) {
            throw new IllegalArgumentException("dateEnding должна быть позже, чем dateOfRegistration.");
        }
        this.dateEnding = typeMembership == ONE_TIME ? dateOfRegistration.plusDays(1) : dateEnding;
        this.typeMembership = typeMembership;
        this.ownerMembership = ownerMembership;
        number = ++id;
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

    public OwnerMembership getOwnerMembership() {
        return ownerMembership;
    }

    public TypeMembership getTypeMembership() {
        return typeMembership;
    }

    public void setOwnerMembership(OwnerMembership membership) {
        if (membership == null) {
            throw new NullPointerException("membership не может быть null.");
        }
        this.ownerMembership = membership;
    }

    @Override
    public String toString() {
        return ownerMembership.toString();
    }
}

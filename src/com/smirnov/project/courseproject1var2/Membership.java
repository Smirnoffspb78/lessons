package com.smirnov.project.courseproject1var2;

import java.time.LocalDate;

/**
 * Абонемент.
 */
public class Membership {
    /**
     * Номер абонемента.
     */
    private final int number;
    /**
     * Счетчик абонементов.
     */
    private static int id;
    /**
     * Дата начала действия абонемента.
     */
    private final LocalDate dateOfRegistration = LocalDate.now();
    /**
     * Дата окончания действия абонемента.
     */
    private final LocalDate dateEnding;
    /**
     * Владелец абонемента.
     */
    private OwnerMembership ownerMembership;
    /**
     * Тип абонемента.
     */
    private final TypeMembership typeMembership;

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
        if (typeMembership == TypeMembership.ONE_TIME) {
            this.dateEnding = LocalDate.now().plusDays(1);
        } else {
            this.dateEnding = dateEnding;
        }
        this.typeMembership = typeMembership;
        this.ownerMembership = ownerMembership;
        number = id++;
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
        return "%s".formatted(ownerMembership);
    }
}

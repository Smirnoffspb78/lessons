package com.smirnov.project.lesson09.homework09;

import java.util.Objects;

/**
 * Транспортное средство.
 */
public class Vehicle {
    /**
     * Номер.
     */
    private String number;
    /**
     * Уровень износа.
     */
    protected int wearLevel;
    /**
     * Максимальная скорость.
     */
    private int speedMax = 120;

    /**
     * Контсруктор, опсиывающий транспортное средтсво.
     *
     * @param number    Номер
     * @param wearLevel Уровень износа
     */
    protected Vehicle(String number, int wearLevel) {
        if (wearLevel < 0 || wearLevel > 100) {
            throw new IllegalArgumentException("Уровень износа не может быть отрицательным или быть больше 100");
        } else if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Номер не должен быть null и иметь хотябы один символ");
        }
        this.number = number;
        this.wearLevel = wearLevel;
    }

    /**
     * Конструктор, описывающий траснпортное средство.
     *
     * @param speedMax Максимальная скорость
     */
    protected Vehicle(int speedMax, String number, int wearLevel) {
        this(number, wearLevel);
        if (speedMax <= 0) {
            throw new IllegalArgumentException("speedMax не может быть отрицательным или 0");
        }
        this.speedMax = speedMax;
    }

    /**
     * Ремонт транспортного средства.
     */
    public void repair() {
        if (wearLevel > 0) {
            wearLevel--;
        }
    }

    public String getNumber() {
        return number;
    }

    public int getWearLevel() {
        return wearLevel;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return wearLevel == vehicle.wearLevel && speedMax == vehicle.speedMax && Objects.equals(number, vehicle.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, wearLevel, speedMax);
    }
}

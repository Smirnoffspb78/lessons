package com.smirnov.project.lesson09.homework09;

/**
 * Транспортное средство.
 */
public class Vehicle {
    /**
     * Номер.
     */
    private int number;
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
    protected Vehicle(int number, int wearLevel) {
        if (wearLevel < 0 || wearLevel > 100) {
            throw new IllegalArgumentException("Уровень износа не может быть отрицательным или быть больше 100");
        } else if (number < 0) {
            throw new IllegalArgumentException("Номер не может быть отрицательным");
        }
        this.number = number;
        this.wearLevel = wearLevel;
    }

    /**
     * Конструктор, описывающий траснпортное средство.
     *
     * @param speedMax Максимальная скорость
     */
    protected Vehicle(int speedMax, int number, int wearLevel) {
        this(number, wearLevel);
        if (speedMax <= 0) {
            throw new IllegalArgumentException("speedMax не может быть отрицательным или 0");
        }
        this.speedMax = speedMax;
    }

    /**
     * Метод изменяет уровень износа транспортного средства.
     */
    public void repair() {
        if (wearLevel > 0)
            wearLevel--;
    }

    public int getNumber() {
        return number;
    }

    public int getWearLevel() {
        return wearLevel;
    }

    public int getSpeedMax() {
        return speedMax;
    }
}

package com.smirnov.project.lesson09.homework09;

import static java.lang.Math.max;

/**
 * Самокат.
 */
public class Scooter extends Bicycle {
    /**
     * Имеет электродвигатель
     */
    private boolean electrical;

    /**
     * Контсруктор, опсиывающий Самокат.
     *
     * @param number    Номер
     * @param wearLevel Уровень износа
     */
    public Scooter(String number, int wearLevel, boolean electrical) {
        super(number, wearLevel);
        this.electrical = electrical;
    }

    /**
     * Конструктор, описывающий самокат.
     *
     * @param speedMax  Максимальная скорость
     * @param number    Номер
     * @param wearLevel Уровень износа
     */
    public Scooter(int speedMax, String number, int wearLevel, boolean electrical) {
        super(speedMax, number, wearLevel);
        this.electrical = electrical;
    }

    public boolean isElectrical() {
        return electrical;
    }

    /**
     * Метод уменьшает износ.
     */
    @Override
    public void repair() {
        if (electrical) {
            wearLevel=max(wearLevel-2, 0);
        } else {
            wearLevel=max(wearLevel-3, 0);
        }
    }
}

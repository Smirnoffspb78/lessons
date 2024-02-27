package com.smirnov.project.lesson09.homework09;

/**
 * Самокат.
 */
public class Scooter extends Bicycle {
    /**
     * Указывает электрический или нет
     */
    private boolean electrical;

    /**
     * Контсруктор, опсиывающий Самокат.
     *
     * @param number    Номер
     * @param wearLevel Уровень износа
     */
    public Scooter(int number, int wearLevel, boolean electrical) {
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
    public Scooter(int speedMax, int number, int wearLevel, boolean electrical) {
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
            wearLevel -= 2;
        } else {
            wearLevel -= 3;
        }
        if (wearLevel < 0) {
            wearLevel = 0;
        }
    }
}

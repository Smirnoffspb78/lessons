package com.smirnov.project.lesson09.homework09;

/**
 * Поезд.
 */
public class Train extends Vehicle {
    /**
     * Количество вагонов.
     */
    private int numberWagon;
    /**
     * Наличие климат контроля
     */
    private boolean climateControl;
    private static final int CHECK_NUMBER_WAGON = 7;

    /**
     * Конструктор создает поезд.
     *
     * @param number         Номер
     * @param wearLevel      Уровень износа
     * @param numberWagon    Число вагонов
     * @param climateControl Климат котроль
     * @throws IllegalArgumentException Если некорректное значение numberWagon
     */
    public Train(int number, int wearLevel, int numberWagon, boolean climateControl) {
        super(number, wearLevel);
        if (numberWagon < 0) throw new IllegalArgumentException("numberWagon  должно быть положительным");
        this.numberWagon = numberWagon;
        this.climateControl = climateControl;
    }

    /**
     * Конструктор создает поезд.
     *
     * @param number         Номер
     * @param wearLevel      Уровень износа
     * @param numberWagon    Число вагонов
     * @param climateControl Климат котроль
     * @param speedMax       Максимальная скорость поезда
     * @throws IllegalArgumentException Если некорректное значение numberWagon
     */
    public Train(int number, int wearLevel, int numberWagon, boolean climateControl, int speedMax) {
        super(speedMax, number, wearLevel);
        if (numberWagon < 0) throw new IllegalArgumentException("numberWagon  должно быть положительным");
        this.numberWagon = numberWagon;
        this.climateControl = climateControl;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public boolean isClimateControl() {
        return climateControl;
    }

    /**
     * Метод уменьшает износ.
     */
    @Override
    public void repair() {
        if (numberWagon > CHECK_NUMBER_WAGON) {
            wearLevel--;
        } else {
            wearLevel -= 2;
            if (wearLevel < 0) {
                wearLevel = 0;
            }
        }
    }
}

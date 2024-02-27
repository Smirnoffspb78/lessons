package com.smirnov.project.lesson09.homework09;

/**
 * Велосипед
 */
public class Bicycle extends Vehicle {
    /**
     * Количество колес.
     */
    private int numberWheel = 2;
    private static final int MIN_WHEEL = 1;
    private static final int MAX_WHEEL = 4;
    /**
     * Тип.
     */
    private String type = "Городской";


    /**
     * Контсруктор, опсиывающий Велосипед.
     *
     * @param number    Номер
     * @param wearLevel Уровень износа
     */
    public Bicycle(int number, int wearLevel) {
        super(number, wearLevel);
    }

    /**
     * Конструктор, описывающий траснпортное средство.
     *
     * @param speedMax  Максимальная скорость
     * @param number    Номер
     * @param wearLevel Максимальный уровень износа
     */
    protected Bicycle(int speedMax, int number, int wearLevel) {
        super(speedMax, number, wearLevel);
    }

    /**
     * Конструктор, описывающий велосипед.
     *
     * @param speedMax  Максимальная скорость
     * @param number    номер
     * @param wearLevel - Уровень износа
     * @throws IllegalArgumentException Если некорректное количесвто колес. Если тип пустой или null
     */
    public Bicycle(int speedMax, int number, int wearLevel, int numberWheel, String type) {
        super(speedMax, number, wearLevel);
        if (numberWheel < MIN_WHEEL || numberWheel > MAX_WHEEL)
            throw new IllegalArgumentException("Количество колес должно быть от%dдо%d".formatted(MIN_WHEEL, MAX_WHEEL));
        this.numberWheel = numberWheel;
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Тип должен иметь хотябы 1 символ");
        this.type = type;
    }

    public int getNumberWheel() {
        return numberWheel;
    }

    public String getType() {
        return type;
    }


}

package com.smirnov.project.lesson10.homework10;

import static com.smirnov.project.lesson10.homework10.TypeBattleUnit.*;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Харакетристики всех юнитов.
 */
public class Units {
    private Units() {
    }

    /**
     * Максимальное количество юнитов в армии короля.
     */
    public static final int MAX_UNIT = 5;
    /**
     * Начальное количество денег у короля.
     */
    public static final int INITIAL_CASH = 500;
    /**
     * Стоимость замены юнита с здоровьем 0 на нового юнита.
     */
    public static final int COST_UNIT = 12;
    /**
     * Стоимсоть найма армии.
     */
    public static final int COST_ARMY = 200;
    /**
     * Ярость рыцаря.
     */
    public static final int RAGE = 2;
    /**
     * Вероятность возникновения ярости рыцаря, [%].
     */
    public static final int PROBABILITY_RAGE = 5;
    /**
     * Верхняя граница вероятности.
     */
    public static final int MAX_PROBABILITY = 100;

    /**
     * Стоимость восстановления здоровья короля при отдыхе.
     */
    public static final int MONEY_ON_HEALTH = 2;

    /**
     * Количество восстанавливаемых очков здоровья у короля при отдыхе.
     */
    public static final int HEALTH_RECOVERY = 5;

    /**
     * Фабрика, генерирующая боевых юнитов.
     *
     * @param type Тип боевого юнита
     * @return Сгенерированный юнит
     */
    public static BattleUnit generateUnit(TypeBattleUnit type) {
        BattleUnit unit;
        unit = switch (type) {
            case KNIGHT -> new Knight(70, 5, 100, 40);
            case INFANTRYMAN -> new Infantryman(70, 5, 200, 30);
        };
        return unit;
    }

    /**
     * Генерирует армию короля случайным образом.
     */
    public static BattleUnit[] randomGenerateArmy() {
        BattleUnit[] battleUnits = new BattleUnit[MAX_UNIT];
        for (int i = 0; i < battleUnits.length; i++) {
            if (current().nextInt(0, 2) == 0) {
                battleUnits[i] = generateUnit(KNIGHT);
            } else {
                battleUnits[i] = generateUnit(INFANTRYMAN);
            }
        }
        return battleUnits;
    }
}

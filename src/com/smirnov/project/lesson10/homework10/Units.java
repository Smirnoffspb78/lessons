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
     * Верхняя граница вероятности.
     */
    public static final int MAX_PROBABILITY = 100;

    /**
     * Фабрика, генерирующая боевых юнитов.
     *
     * @param type Тип боевого юнита
     * @return Сгенерированный юнит
     */
    public static BattleUnit generateUnit(TypeBattleUnit type) {
        if (type == null) {
            throw new IllegalArgumentException("Тип не должен быть null");
        }
        return switch (type) {
            case KNIGHT -> new Knight(70, 5, 100, 40);
            case INFANTRYMAN -> new Infantryman(70, 5, 200, 30);
        };
    }

    /**
     * Генерирует армию короля случайным образом.
     */
    public static BattleUnit[] randomGenerateArmy(int arraySize) {
        BattleUnit[] battleUnits = new BattleUnit[arraySize];
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

package com.smirnov.project.lesson10.homework10;

import static com.smirnov.project.lesson10.homework10.Units.*;
import static java.lang.Math.min;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Рыцарь.
 */
public class Knight extends BattleUnit implements UnitFunctional {
    private static int attackCounter;

    /**
     * Конструктор создает рыцаря.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     * @param attackForce   Сила атаки
     * @see BattleUnit
     */
    protected Knight(int healthInitial, double velocity, double cash, int attackForce) {
        super(healthInitial, velocity, cash, attackForce);
    }

    /**
     * Атака боевого юнита.
     *
     * @param attackedUnit Атакуемый юнит.
     */

    @Override
    public boolean attack(BattleUnit attackedUnit) {
        if (getHealth() > 0 && !attackedUnit.equals(this)) {
            if (current().nextInt(MAX_PROBABILITY) >= PROBABILITY_RAGE) {
                attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
            } else {
                attackedUnit.setHealth(attackedUnit.getHealth() - RAGE * getAttackForce());
            }
            if (attackedUnit instanceof Knight && attackCounter == 0 && attackedUnit.getHealth() > 1
                    && attackedUnit.getVelocity() >= getVelocity()) {
                attackedUnit.attack(this);
                attackCounter++;
            } else {
                attackCounter = 0;
            }
            return true;
        } else {
            return false;
        }
    }


    /**
     * Восстановление здоровья, обменивая деньги юнита на здоровье.
     *
     * @param unit Юнит
     */
    @Override
    public boolean toHel(Unit unit, int healthPoint) {
        if (unit.getCash() >= healthPoint && unit.getHealth() > 0 && !unit.equals(this) && getHealth() > 0) {
            setCash(getCash() + min(healthPoint, unit.getHealthInitial() - unit.getHealth()));
            unit.setCash(unit.getCash() - min(healthPoint, unit.getHealthInitial() - unit.getHealth()));
            unit.setHealth(min(unit.getHealth() + healthPoint, unit.getHealthInitial()));
            return true;
        }
        return false;
    }


}

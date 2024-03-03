package com.smirnov.project.lesson10.homework10;

import static com.smirnov.project.lesson10.homework10.Units.*;
import static java.lang.Math.min;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Рыцарь.
 */
public class Knight extends BattleUnit implements UnitHealing {

    /**
     * Ярость рыцаря.
     */
    private static final int RAGE = 2;
    /**
     * Вероятность возникновения ярости рыцаря, [%].
     */
    private static final int PROBABILITY_RAGE = 5;
    private static int attackCounter;

    /**
     * Конструктор создает рыцаря.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     * @param attackForce   Сила атаки
     */
    protected Knight(int healthInitial, double velocity, double cash, int attackForce) {
        super(healthInitial, velocity, cash, attackForce);
    }

    /**
     * Атака боевого юнита.
     *
     * @param attackedUnit Атакуемый юнит.
     * @Return true/false, если атака выполнена/не выполнена
     */

    @Override
    public boolean attack(BattleUnit attackedUnit) {
        if (attackedUnit!=null && getHealth() > 0 && attackedUnit!=this && attackedUnit.getHealth()>0) {
            if (current().nextInt(MAX_PROBABILITY) >= PROBABILITY_RAGE) {
                attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
            } else {
                attackedUnit.setHealth(attackedUnit.getHealth() - RAGE * getAttackForce());
            }
            if (attackedUnit instanceof Knight && attackCounter == 0 && attackedUnit.getHealth() > 1
                    && attackedUnit.getVelocity() >= getVelocity()) {
                attackCounter++;
                attackedUnit.attack(this);
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
    public boolean toHeal(Unit unit, int healthPoint) {
        if (unit!=null && unit.getCash() >= healthPoint && unit.getHealth() > 0 && !unit.equals(this)
                && getHealth() > 0) {
            int healthPlus=unit.getHealth();
            int maxHealth=unit.getHealthInitial();
            setCash(getCash() + min(healthPoint, maxHealth - healthPlus));
            unit.setCash(unit.getCash() - min(healthPoint, maxHealth - healthPlus));
            unit.setHealth(min(healthPlus + healthPoint, maxHealth));
            return true;
        }
        return false;
    }


}

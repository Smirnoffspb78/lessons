package com.smirnov.project.lesson10.homework10;

/**
 * Пехотинец.
 */
public class Infantryman extends BattleUnit {
    /**
     * Минимальное здоровье противника для повторной атаки.
     */
    private static final int MIN_HEALTH_FOR_DOUBLE_ATTACK = 5;

    /**
     * Контсруктор создает пехотинца.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     * @param attackForce   Сила атаки
     */
    public Infantryman(int healthInitial, double velocity, int cash, int attackForce) {
        super(healthInitial, velocity, cash, attackForce);
    }

    private void attackKnight(BattleUnit attackedUnit) {
        if (attackedUnit instanceof Knight && attackedUnit.getHealth() != 0 && attackedUnit.getVelocity() >= getVelocity()) {
            attackedUnit.attack(this);
        }
    }

    /**
     * Атака.
     *
     * @param attackedUnit Атакуемый юнит
     * @Return true/false, если атака выполнена/не выполнена
     */
    @Override
    public boolean attack(BattleUnit attackedUnit) {
        if (attackedUnit!=null && getHealth() > 0 && attackedUnit!=this && attackedUnit.getHealth()>0) {
            attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
            attackKnight(attackedUnit);
            if (getVelocity() >= attackedUnit.getVelocity() && attackedUnit.getHealth() < MIN_HEALTH_FOR_DOUBLE_ATTACK) {
                attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
                attackKnight(attackedUnit);
            }
            return true;
        }
        return false;
    }
}

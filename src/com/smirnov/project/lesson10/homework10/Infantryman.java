package com.smirnov.project.lesson10.homework10;

/**
 * Пехотинец.
 */
public class Infantryman extends BattleUnit {
    /**
     * Минимальное здоровье противника для повторной атаки.
     */
    private final int minHealthForDoubleAttack = 5;

    /**
     * Контсруктор создает пехотинца.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     * @param attackForce   Сила атаки
     * @see BattleUnit
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
     */
    @Override
    public boolean attack(BattleUnit attackedUnit) {
        if (getHealth() > 0 && !attackedUnit.equals(this)) {
            attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
            attackKnight(attackedUnit);
            if (getVelocity() >= attackedUnit.getVelocity() && attackedUnit.getHealth() < minHealthForDoubleAttack) {
                attackedUnit.setHealth(attackedUnit.getHealth() - getAttackForce());
                attackKnight(attackedUnit);
            }
            return true;
        }
        return false;
    }
}

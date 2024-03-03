package com.smirnov.project.lesson10.homework10;

import static java.lang.Math.min;

/**
 * Боевой юнит.
 */
public abstract class BattleUnit extends Unit {

    /**
     * Сила атаки, [health].
     */
    private int attackForce;

    /**
     * Конструктор создает атакующего юнита.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     * @param attackForce   Сила атаки
     * @throws IllegalArgumentException Если здоровье, скорость или сила атаки неположиетльные. Если количество денег отрицательное
     * @see Unit
     */
    protected BattleUnit(int healthInitial, double velocity, double cash, int attackForce) {
        super(healthInitial, velocity, cash);
        setAttackForce(attackForce);
    }

    /**
     * Атака.
     */
    protected abstract boolean attack(BattleUnit attackedUnit);

    public int getAttackForce() {
        return attackForce;
    }

    public void setAttackForce(int attackForce) {
        if (attackForce <= 0) {
            throw new IllegalArgumentException("Cила атаки должна быть положительной.");
        }
        this.attackForce = attackForce;
    }

    /**
     * Восстанавливает здоровье.
     */
    @Override
    public void rest() {
        if (getHealth() < getHealthInitial()) {
            setHealth(min(getHealth() + 2, getHealthInitial()));
        }
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + getHealth() +
                ", attackForce=" + attackForce +
                /*", healthInitial=" + healthInitial +
                ", velocity=" + velocity +
                ", cash=" + cash +*/
                '}';
    }
}

package com.smirnov.project.lesson10.homework10;

import static java.lang.Math.max;

/**
 * Обычный юнит.
 */
public class Unit {
    /**
     * Текущее здоровье.
     */
    private int health;

    /**
     * Начальное здоровье.
     */
    private final int healthInitial;
    /**
     * Скорость, [км/ч].
     */
    private double velocity;
    /**
     * Количество денег.
     */
    private double cash;

    /**
     * Конструктор создает юнита.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @param cash          Количество денег
     */
    public Unit(int healthInitial, double velocity, double cash) {
        if (healthInitial < 1 || velocity <= 0 || cash < 0) {
            throw new IllegalArgumentException("Здоровье должно быть положительным. \n Скорость должна быть положительной. \n Количество денег не может быть отрицательным.");
        }
        this.healthInitial = healthInitial;
        this.velocity = velocity;
        this.cash = cash;
        this.health = healthInitial;
    }

    /**
     * Восстанавливает здоровье.
     */
    public void rest() {
        if (health < healthInitial) {
            health++;
        }
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = max(health, 0);
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        if (velocity <= 0) {
            throw new IllegalArgumentException("Скорость не может быть отрицательной");
        }
        this.velocity = velocity;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Количество денег не может быть отрицательным.");
        }
        this.cash = cash;
    }

    public int getHealthInitial() {
        return healthInitial;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                '}';
    }
}
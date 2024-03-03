package com.smirnov.project.lesson10.homework10;

/**
 * Дополнительный функционал юнитов.
 */
public interface UnitHealing {
    /**
     * Восстановление здоровья.
     */
    boolean toHeal(Unit unit, int healthPoint);
}

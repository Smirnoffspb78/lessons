package com.smirnov.project.lesson10.homework10;

import java.util.Arrays;

import static com.smirnov.project.lesson10.homework10.Units.*;
import static java.lang.Math.min;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Король.
 */
public class King extends Unit {

    /**
     * Указатель на текущее свободное место в армии.
     */
    private int counterUnit = 0;

    /**
     * Армия.
     *
     * @see BattleUnit
     */
    private BattleUnit[] battleUnits = new BattleUnit[MAX_UNIT];


    /**
     * Коонструктор создает короля.
     *
     * @param healthInitial Начальное здоровье
     * @param velocity      Скорость
     * @see Unit
     */

    public King(int healthInitial, double velocity) {
        super(healthInitial, velocity, INITIAL_CASH);
    }

    /**
     * Наем новой армии.
     *
     * @return true/false если дсотаточно/недостаточно денег для наемая армии
     */
    public boolean createArmy() {
        if (getCash() > COST_ARMY) {
            setCash(getCash() - COST_ARMY);
            battleUnits = Units.randomGenerateArmy();
            counterUnit = MAX_UNIT;
            return true;
        }
        return false;
    }

    /**
     * Заменяет юнита с здоровьем 0 на нового.
     *
     * @param typeBattleUnit Тип юнита
     * @return true/false если юнит заменился/если в рамии нет юнитов с здоровьем 0 или армия пуста
     */
    public boolean updateUnitInArmy(TypeBattleUnit typeBattleUnit) {
        if (battleUnits[0] != null && getCash() > COST_UNIT && counterUnit < MAX_UNIT) {
            setCash(getCash() - COST_UNIT);
            battleUnits[counterUnit] = Units.generateUnit(typeBattleUnit);
            counterUnit++;
            return true;
        }
        return false;
    }

    /**
     * Вспомогательный метод. Перемещает воинов со здоровье 0 в конец.
     *
     * @param temp                   Номер атакуемого юнита
     * @param kingAttacked           Атакуемый король
     * @param aliveUnitsAttackedKing Количество живых юнитов
     * @return Оставшееся количество живых юнитов
     */
    private int sortArmyInBattle(int temp, King kingAttacked, int aliveUnitsAttackedKing) {
        BattleUnit tempBattleunit = kingAttacked.battleUnits[temp];
        aliveUnitsAttackedKing--;
        for (int i = temp; i < aliveUnitsAttackedKing; i++) {
            kingAttacked.battleUnits[i] = kingAttacked.battleUnits[i + 1];
        }
        kingAttacked.battleUnits[aliveUnitsAttackedKing] = tempBattleunit;
        return aliveUnitsAttackedKing;
    }

    /**
     * Вспомогательный метод. Определяет ипобителя и награду.
     *
     * @param aliveUnitsThisKing     Количество выживших воинов напавшего короля
     * @param aliveUnitsAttackedKing Количество выживших воинов короля, на которого напали
     * @param kingAttacked           Атакуемый король
     */
    private void resultBattle(int aliveUnitsThisKing, int aliveUnitsAttackedKing, King kingAttacked) {
        if (aliveUnitsThisKing > aliveUnitsAttackedKing) {
            setCash(getCash() + kingAttacked.getCash() / 2);
            kingAttacked.setCash(kingAttacked.getCash() / 2);
        } else {
            kingAttacked.setCash(getCash() / 2 + kingAttacked.getCash());
            setCash(getCash() / 2);
        }

    }

    /**
     * Атака.
     *
     * @param kingAttacked Король, на которого нападают
     */

    protected boolean attack(King kingAttacked) {
        if (!kingAttacked.equals(this) && battleUnits[0] != null) {
            int temp;
            int numberThisUnit = 0;
            int numberAttackedUnit = 0;
            int aliveUnitsThisKing = counterUnit;
            int aliveUnitsAttackedKing = kingAttacked.getCounterUnit();
            while (aliveUnitsAttackedKing != 0 && aliveUnitsThisKing != 0) {
                numberAttackedUnit = numberAttackedUnit >= aliveUnitsAttackedKing ? 0 : numberAttackedUnit;
                numberThisUnit = numberThisUnit >= aliveUnitsThisKing ? 0 : numberThisUnit;
                temp = current().nextInt(aliveUnitsAttackedKing);
                battleUnits[numberThisUnit].attack(kingAttacked.battleUnits[temp]);
                if (kingAttacked.battleUnits[temp].getHealth() == 0) {
                    aliveUnitsAttackedKing = sortArmyInBattle(temp, kingAttacked, aliveUnitsAttackedKing);
                    numberAttackedUnit = temp < numberAttackedUnit ? numberAttackedUnit - 1 : numberAttackedUnit;
                }
                temp = current().nextInt(aliveUnitsThisKing);
                kingAttacked.battleUnits[numberAttackedUnit].attack(battleUnits[temp]);
                if (battleUnits[temp].getHealth() == 0) {
                    aliveUnitsThisKing = sortArmyInBattle(temp, this, aliveUnitsThisKing);
                    numberThisUnit = temp < numberThisUnit ? numberThisUnit - 1 : numberThisUnit;
                }
                numberAttackedUnit++;
                numberThisUnit++;
            }
            counterUnit = aliveUnitsThisKing;
            kingAttacked.setCounterUnit(aliveUnitsAttackedKing);
            resultBattle(aliveUnitsThisKing, aliveUnitsAttackedKing, kingAttacked);
            return true;
        }
        return false;
    }

    public BattleUnit[] getBattleUnits() {
        return battleUnits.clone();
    }

    public int getCounterUnit() {
        return counterUnit;
    }

    public void setCounterUnit(int counterUnit) {
        this.counterUnit = counterUnit;
    }

    /**
     * Отдых.
     */
    @Override
    public void rest() {
        if (getHealth() < getHealthInitial() && getCash() >= MONEY_ON_HEALTH) {
            setHealth(min(getHealth() + HEALTH_RECOVERY, getHealthInitial()));
            setCash(getCash() - MONEY_ON_HEALTH);
        }
    }

    @Override
    public String toString() {
        return "King{" +
                "battleUnits=" + Arrays.toString(battleUnits) +
                '}';
    }
}

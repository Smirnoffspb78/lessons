package com.smirnov.project.lesson09.homework09;

/**
 * Мастерская.
 */
public class Workshop {
    /**
     * Траснпортные средства.
     *
     * @see Vehicle
     */
    private Vehicle[] vehicles;
    /**
     * Указатель на текущее свободное ремеонтное место.
     */
    private int counter;
    /**
     * Вспомогательный массив для получения информации.
     */
    private Vehicle[] copyVehicles;
    /**
     * Размер мастерской (количество одновременно ремонтируемых транспортных средств).
     */
    private final int lengthWorkshop;

    /**
     * Конструктор для создания мастерской
     *
     * @param lengthWorkshop - размер мастерской (количество одновременно ремонтируемых транспортных средств).
     * @throws IllegalArgumentException - если дина Vehicle не положительная
     */

    public Workshop(int lengthWorkshop) {
        if (lengthWorkshop < 1) throw new IllegalArgumentException("Длина массива Vehicle не может быть отрицательной");
        this.lengthWorkshop = lengthWorkshop;
        vehicles = new Vehicle[lengthWorkshop];
        copyVehicles = new Vehicle[lengthWorkshop];
    }

    /**
     * Метод добавляет изделие на ремонт в мастерскую, если мастерская не заполнена.
     *
     * @param vehicle транспортное средство
     * @return true/false если добавилось/не добавилось транспортное средсво на ремонт
     */
    public boolean addVehicles(Vehicle vehicle) {
        if (counter < vehicles.length) {
            vehicles[counter] = vehicle;
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Осуществляет одно действие ремонта всех транспортных средств, находящихся на ремонте
     */
    public void repairAll() {
        int checkRepair = 0;
        for (int i = 0; i < counter; i++) {
            vehicles[i].repair();
            if (checkRepair != 0) {
                vehicles[i - checkRepair] = vehicles[i];
            }
            checkRepair = vehicles[i].getWearLevel() == 0 ? checkRepair + 1 : checkRepair;
        }

        if (checkRepair != 0) {
            for (int i = counter - 1; i > counter - 1 - checkRepair; i--) {
                vehicles[i] = null;
            }
            counter -= checkRepair;
        }
    }

    /**
     * Выполняет полный ремонт всех транспортных средств.
     */
    public void repairAllFull() {
        for (int i = 0; i < counter; i++) {
            while (vehicles[i].getWearLevel() > 0) {
                vehicles[i].repair();
            }
            vehicles[i] = null;
        }
        counter = 0;
    }

    public int getLengthWorkshop() {
        return lengthWorkshop;
    }

    public Vehicle[] getVehicles() {
        copyVehicles = vehicles.clone();
        return copyVehicles;
    }

    public int getCounter() {
        return counter;
    }
}

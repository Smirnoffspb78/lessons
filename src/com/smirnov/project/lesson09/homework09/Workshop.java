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
     * Размер мастерской (количество одновременно ремонтируемых транспортных средств).
     */
    private final int lengthWorkshop;

    /**
     * Конструктор для создания мастерской
     *
     * @param lengthWorkshop - Размер мастерской (количество одновременно ремонтируемых транспортных средств).
     * @throws IllegalArgumentException - Если размер мастерской неположительный
     */

    public Workshop(int lengthWorkshop) {
        if (lengthWorkshop < 1) {
            throw new IllegalArgumentException("Размер мастерской не может быть меньше 1");
        }
        this.lengthWorkshop = lengthWorkshop;
        vehicles = new Vehicle[lengthWorkshop];
    }

    /**
     * Метод добавляет изделие на ремонт в мастерскую, если мастерская не заполнена.
     *
     * @param vehicle транспортное средство
     * @return true/false если добавилось/не добавилось транспортное средсво на ремонт
     */
    public boolean addVehicles(Vehicle vehicle) {
        if (counter < vehicles.length) {
            vehicles[counter++] = vehicle;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Осуществляет одно действие ремонта всех транспортных средств, находящихся на ремонте.
     */
    public void repairAll() {
        for (int i = 0; i < counter; i++) {
            vehicles[i].repair();
            vehicles[i] = null;
        }
        counter = 0;
    }

    public int getLengthWorkshop() {
        return lengthWorkshop;
    }

    public Vehicle[] getVehicles() {
        return vehicles.clone();
    }

}

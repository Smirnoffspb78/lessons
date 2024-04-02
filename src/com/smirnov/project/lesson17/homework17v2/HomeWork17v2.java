package com.smirnov.project.lesson17.homework17v2;

import com.smirnov.project.lesson14.vehicle.Repaintable;
import com.smirnov.project.lesson14.vehicle.Vehicle;

import java.util.*;


public class HomeWork17v2 {
    private HomeWork17v2() {
    }

    /**
     * Возвращает список транспортных средств, уровень износа которых больше переданного значения.
     *

     * @param vehicle     Map транспортных средств
     * @param levelOfWear Уровень износа
     * @param T           extends Vehicle
     * @return Список транспортных средств, уровень износа которых больше переданного
     */
    public static <T extends Vehicle> List<T> vehiclesWithLevelOfWear(Map<String, T> vehicle, int levelOfWear) {
        Objects.requireNonNull(vehicle);
        if (levelOfWear < 0 || levelOfWear > 100) {
            throw new IllegalArgumentException("levelOfWear<0 или levelOfWear>100");
        }
        if (vehicle.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> vehiclesWithLevel = new ArrayList<>();
        for (T value : vehicle.values()) {

            Objects.requireNonNull(value);
            if (value.getLevelOfWare() > levelOfWear) {
                vehiclesWithLevel.add(value);
            }
        }
        return vehiclesWithLevel;
    }

    /**
     * Возвращает список транспортных средств, уровень износа которых больше переданного значения (вариант с Wildcard).
     *

     * @param vehicle     Map транспортных средств
     * @param levelOfWear Уровень износа
     * @return Список транспортных средств, уровень износа которых больше переданного
     */
    public static List<?> vehiclesWithLevelOfWear2(Map<String, ? extends Vehicle> vehicle, int levelOfWear) {
        Objects.requireNonNull(vehicle);
        if (levelOfWear < 0 || levelOfWear > 100) {
            throw new IllegalArgumentException("levelOfWear<0 или levelOfWear>100");
        }
        if (vehicle.isEmpty()) {
            return new ArrayList<>();
        }
        List<? super Vehicle> vehiclesWithLevel = new ArrayList<>();
        for (Vehicle value : vehicle.values()) {

            Objects.requireNonNull(value);
            if (value.getLevelOfWare() > levelOfWear) {
                vehiclesWithLevel.add(value);
            }
        }
        return vehiclesWithLevel;
    }

    /**
     * Наполняет Map перекрашиваемыми транспортными средствами.
     *
     * @param vehicle    Транспортные средства
     * @param mapRepaint Map, где ключ - цвет, список - транспортные средства с цветом по ключу
     */
    public static <T extends Vehicle & Repaintable> void repaintVehicle(List<T> vehicle, Map<Repaintable.Color, List<T>> mapRepaint) {
        Objects.requireNonNull(vehicle);
        Objects.requireNonNull(mapRepaint);

        for (T t : vehicle) {
            Objects.requireNonNull(t);
            if (mapRepaint.containsKey(t.getColor())) {
                mapRepaint.get(t.getColor()).add(t);
            }
        }
    }

    /**
     * Возвращает Map отремонтированных транспортных средств.
     *
     * @param listVehicle Список транспортных средств
     * @param T           extends Vehicle
     * @return Map, где ключ - номер транспортного средства, значение - транспортное средство
     */
    public static <T extends Vehicle> Map<String, T> vehicleRepair(List<T> listVehicle) {
        Objects.requireNonNull(listVehicle);
        if (listVehicle.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, T> mapVehicle = new HashMap<>();
        for (T t : listVehicle) {
            Objects.requireNonNull(t);
            if (!mapVehicle.containsKey(t.getNumber())) {
                t.repair();
                mapVehicle.put(t.getNumber(), t);
            }

        }
        return mapVehicle;
    }

    /**
     * Возвращает Map отремонтированных транспортных средств (вариант с Wildcard).
     *
     * @param listVehicle Список транспортных средств
     * @return Map, где ключ - номер транспортного средства, значение - транспортное средство
     */
    public static Map<String, ?> vehicleRepair2(List<? extends Vehicle> listVehicle) {
        Objects.requireNonNull(listVehicle);
        if (listVehicle.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, ? super Vehicle> mapVehicle = new HashMap<>();
        for (Vehicle t : listVehicle) {
            Objects.requireNonNull(t);
            if (!mapVehicle.containsKey(t.getNumber())) {
                t.repair();
                mapVehicle.put(t.getNumber(), t);
            }

        }
        return mapVehicle;
    }
}

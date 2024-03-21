package com.smirnov.project.lesson15.homework15;

import java.util.Comparator;
import java.util.Objects;

/**
 * Компараторы для склада фруктов.
 */
public class ComparatorsFruits {

    private ComparatorsFruits() {
    }

    private static void checkNull(FruitToStorageInfo fruit1, FruitToStorageInfo fruit2) {
        Objects.requireNonNull(fruit1, "fruit1=null.");
        Objects.requireNonNull(fruit2, "fruit2=null.");
    }

    /**
     * Компаратор по количеству фруктов.
     */
    public static class NumberOfFruits implements Comparator<FruitToStorageInfo> {
        /**
         * Сортирует фрукты по убывания количества.
         *
         * @param fruit1 the first object to be compared.
         * @param fruit2 the second object to be compared.
         * @return -1 если 02>01, 0 если 01=02 иначе 1
         */
        @Override
        public int compare(FruitToStorageInfo fruit1, FruitToStorageInfo fruit2) {
            checkNull(fruit1, fruit2);
            return fruit2.getCount() - fruit1.getCount();
        }
    }

    /**
     * Компаратор по типу (по алфавиту).
     */
    public static class TypeOfFruit implements Comparator<FruitToStorageInfo> {
        /**
         * Сортирует фрукты по алфавиту.
         *
         * @param fruit1 Фрукт №1
         * @param fruit2 Фрукт №2
         * @return отсортированный склад по алфавиту
         */
        @Override
        public int compare(FruitToStorageInfo fruit1, FruitToStorageInfo fruit2) {
            checkNull(fruit1, fruit2);
            return fruit2.getType().compareTo(fruit1.getType());
        }
    }

    /**
     * Компаратор по возрастанию стоимости.
     */
    public static class PriceOfFruit implements Comparator<FruitToStorageInfo> {
        /**
         * Сортирует фрукты по возрастанию стоимости
         *
         * @param fruit1 Фрукт №1
         * @param fruit2 Фрукт №2
         * @return отсортированные значения по возрастанию стоимости
         */
        @Override
        public int compare(FruitToStorageInfo fruit1, FruitToStorageInfo fruit2) {
            checkNull(fruit1, fruit2);
            return Double.compare(fruit1.getPrice(), fruit2.getPrice());
        }
    }

    /**
     * Компаратор по количеству (по возрастанию) и стоимости (по убыванию).
     */
    public static class NumberAndPriceFruit implements Comparator<FruitToStorageInfo> {

        /**
         * Сортирует фрукты по количеству (возрастанию) и стоимости (убыванию).
         *
         * @param fruit1 Фрукт №1
         * @param fruit2 Фрукт №2
         * @return отсортированные значения по возрастанию количества фруктов и уменьшению цены
         */
        @Override
        public int compare(FruitToStorageInfo fruit1, FruitToStorageInfo fruit2) {
            checkNull(fruit1, fruit2);
            if (fruit1.getCount() == fruit2.getCount()) {
                return -Double.compare(fruit1.getPrice(), fruit2.getPrice());
            }
            return fruit1.getCount() - fruit2.getCount();
        }
    }
}

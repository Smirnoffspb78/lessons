package com.smirnov.project.lesson15.homework15;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

// склад содержит информацию о добавленных фруктах+
public class FruitStorage {
    // максимальное количество фруктов
    // заполняемость зависит не от количества переданных FruitToStorageInfo,
    // а от значения свойства count
    private final int numberOfSlots;
    private int numberOfEmptySlots;

    // коллекция fruits, для хранения экземпляров FruitToStorageInfo
    private final HashSet<FruitToStorageInfo> fruits = new HashSet<>();
    // TODO: КОЛЛЕКЦИЮ ВЫБРАТЬ САМОСТОЯТЕЛЬНО: HashSet: для проверки наличия элемента в коллекции по методу equals (contains): O(1) по хэшкоду.

    public FruitStorage(int numberOfSlots) {
        if (numberOfSlots < 0) {
            throw new IllegalArgumentException("numberOfSlots должен быть положительным");
        }
        this.numberOfSlots = numberOfSlots;
        numberOfEmptySlots = numberOfSlots;
    }

    // TODO: НАПИСАТЬ РЕАЛИЗАЦИЮ СЛЕДУЮЩИХ МЕТОДОВ
    public boolean addToStorage(FruitToStorageInfo toStorageInfo) {
        // Информация о фруктах добавляется в хранилище по следующим правилам:
        // 1. fruit не может быть null;
        if (toStorageInfo == null || numberOfEmptySlots == 0) {
            return false;
        }
        // 2. fruit не может быть ссылкой на существующий элемент коллекции
        // 3. если в коллекции fruits уже есть фрукт с типом и ценой, как у toStorageInfo,         // п.3 является исключающим для п.2., Проверка по equals является достаточно для не добавления нового экземпляра в коллекцию, при этом contains не является достаточным для добавления в любом случае
        //   увеличивать значение свойства count фрукта коллекции на значение свойства count toStorageInfo.
        if (fruits.contains(toStorageInfo)) {
            for (FruitToStorageInfo fruit : fruits) {
                if (fruit.equals(toStorageInfo)) {
                    fruit.setCount(min(fruit.getCount() + toStorageInfo.getCount(), fruit.getCount() + numberOfEmptySlots));
                    numberOfEmptySlots = max(numberOfEmptySlots - toStorageInfo.getCount(), 0);
                    return false;
                }
            }
        }

        //   В противном случае добавлять toStorageInfo в коллекцию fruits.
        //   numberOfSlots уменьшается на значение count добавляемого фрукта.
        // 4. в хранилище нельзя добавить больше numberOfSlots фруктов
        if (numberOfEmptySlots - toStorageInfo.getCount() < 0) {
            FruitToStorageInfo fruitToStorageInfo = toStorageInfo.clone();
            fruitToStorageInfo.setCount(numberOfEmptySlots);
            fruits.add(fruitToStorageInfo);
            numberOfEmptySlots = 0;
            return true;
        }
        fruits.add(toStorageInfo.clone());
        numberOfEmptySlots -= toStorageInfo.getCount();
        return true;
    }

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(FruitToStorageInfo.FruitType fruitType) {
        int countType = 0;
        for (FruitToStorageInfo typeFruits : fruits) {
            if (typeFruits.getType() == fruitType) {
                countType += typeFruits.getCount();
            }
        }
        return countType;
    }

    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots() {
        return numberOfEmptySlots;
    }

    // value может быть в диапазоне [10; 30)
    // увеличить цену всех фруктов на value процентов
    public void increasePrice(int value) {
        if (value < 10 || value >= 30) throw new IllegalArgumentException("10=<value<30");
        for (FruitToStorageInfo fruit : fruits) {
            fruit.setPrice(fruit.getPrice() * (1 + (double) value / 100));
        }
    }

    // возвращает список, в который войдут фрукты из коллекции fruits
    // с типом fruitType и ценой не выше maxPrice
    public List<FruitToStorageInfo> getFruitsByTypeAndPrice(FruitToStorageInfo.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной, fruitType не null
        ArrayList<FruitToStorageInfo> fruitsByTypeAndPrice = new ArrayList<>();
        if (fruitType == null) {
            throw new NullPointerException(null);
        } else if (maxPrice <= 0) {
            throw new IllegalArgumentException("maxPrice должна быть положительной");
        }
        for (FruitToStorageInfo fruit : fruits) {
            if (fruit.getType() == fruitType && fruit.getPrice() <= maxPrice) {
                fruitsByTypeAndPrice.add(fruit.clone());
            }
        }
        return fruitsByTypeAndPrice;
    }

    // вернуть минимальную цену фрукта с типом fruitType
    public double getMinPriceByType(FruitToStorageInfo.FruitType fruitType) {
        double minPrice = Double.POSITIVE_INFINITY;
        for (FruitToStorageInfo fruit : fruits) {
            if (fruitType == fruit.getType() && fruit.getPrice() < minPrice) {
                minPrice = fruit.getPrice();
            }
        }
        if (minPrice == Double.POSITIVE_INFINITY) {
            return 0;
        }
        return minPrice;
    }



    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public HashSet<FruitToStorageInfo> getFruits() {
        return (HashSet<FruitToStorageInfo>) fruits.clone();
    }

    @Override
    public String toString() {
        return "FruitStorage{" +
                "arrayFruits=" + fruits +
                '}';
    }
}

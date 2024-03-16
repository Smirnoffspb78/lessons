package com.smirnov.project.lesson15.homework15;

import java.util.Objects;

// содержит информацию о фруктах,
// которые будут добавляться на склад
public class FruitToStorageInfo implements Cloneable {
    private final FruitType type;
    private double price; // за один фрукт
    private int count; // количество добавляемых фруктов

    // конструктор, принимающий значения всех свойств + проверки
    public FruitToStorageInfo(FruitType type, double price, int count) {
        if (type == null) throw new NullPointerException("type=null");
        setPrice(price);
        setPrice(count);
        this.type = type;
    }

    // доступные геттеры и сеттеры
    public FruitType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count должен быть положительными");
        }
        this.count = count;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price должен быть положительными");
        }
        this.price = price;
    }

    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT;
    }
    // equals + hashCode + toString

    @Override
    public String toString() {
        return "Тип: " + type +
                ". Цена: " + price +
                ". Количество: " + count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FruitToStorageInfo that)) return false;
        return Double.compare(price, that.price) == 0 && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }

    @Override
    public FruitToStorageInfo clone() {
        FruitToStorageInfo fruit;
        try {
            fruit = (FruitToStorageInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return fruit;
    }

}

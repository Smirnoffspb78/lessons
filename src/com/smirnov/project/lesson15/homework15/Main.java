package com.smirnov.project.lesson15.homework15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.smirnov.project.lesson15.homework15.FruitToStorageInfo.FruitType.*;

public class Main {
    public static void main(String[] args) {
        FruitToStorageInfo fruitToStorageInfo = new FruitToStorageInfo(BANANA, 100, 5);
        FruitToStorageInfo fruitToStorageInfo1 = new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo3 = new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo4 = new FruitToStorageInfo(BANANA, 95, 5);
        FruitToStorageInfo fruitToStorageInfo5 = new FruitToStorageInfo(APPLE, 95, 5);

        FruitStorage fruitStorage = new FruitStorage(18);

        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo));
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo1));
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo3));
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo4));
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo5));
        System.out.println(fruitStorage);
        System.out.println("Количество свободных мест: " + fruitStorage.getNumberOfEmptySlots());

        System.out.println("Количество фруктов определенного типа: " + fruitStorage.getNumberOfFruitsByType(BANANA));

        System.out.println("Бананы с ценой не выше 99: " + fruitStorage.getFruitsByTypeAndPrice(BANANA, 50));
        System.out.println("Бананы с ценой не выше 99: " + fruitStorage.getFruitsByTypeAndPrice(BANANA, 99));
        System.out.println("Бананы с ценой не выше 100: " + fruitStorage.getFruitsByTypeAndPrice(BANANA, 100));
        System.out.println("Минимальная цена бананов: " + fruitStorage.getMinPriceByType(BANANA));
        System.out.println("Минимальная цена яблок: " + fruitStorage.getMinPriceByType(APPLE));
        fruitStorage.increasePrice(10);
        System.out.println("Коллекция после изменения цены" + fruitStorage);

        //Изменение доступного объекта fruitToStorageInfo извне не приводит к изменению объектов коллекции
        //Иначе бы возможна была такая ситуация, что фруктов оказалось больше, чем свободного места
        fruitToStorageInfo.setCount(20);
        System.out.println(fruitToStorageInfo);
        System.out.println(fruitStorage);

        int[]a={1,2,3};
        ArrayList<Integer> arrayA=new ArrayList<>();
        Collections.addAll(Arrays.asList(a));
        Integer[] b=(Integer[]) arrayA.toArray();
        System.out.println(b);

    }
}

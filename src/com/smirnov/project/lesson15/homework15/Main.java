package com.smirnov.project.lesson15.homework15;

import static com.smirnov.project.lesson15.homework15.FruitToStorageInfo.FruitType.*;

public class Main {
    public static void main(String[] args) {
        FruitToStorageInfo fruitToStorageInfo = new FruitToStorageInfo(BANANA, 100, 5);
        FruitToStorageInfo fruitToStorageInfo1 = new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo2 = fruitToStorageInfo1;
        FruitToStorageInfo fruitToStorageInfo3 = new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo4 = new FruitToStorageInfo(BANANA, 95, 5);
        FruitToStorageInfo fruitToStorageInfo5 = new FruitToStorageInfo(APPLE, 95, 5);

        FruitStorage fruitStorage = new FruitStorage(18);


        try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo));
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo, fruitStorage);
        }

        try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo1));
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo, fruitStorage);
        }
     /*   try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo2)); //Исключительная ситуация
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo, fruitStorage);
        }*/
        try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo3));
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo3, fruitStorage);
        }
        try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo4));
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo4, fruitStorage);
        }
    /*    try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo5)); //Исключительная ситуация
        } catch (MaxCountExceededException e) {
            maxCountExceededExceptionHandling(e, fruitToStorageInfo5, fruitStorage);
        }*/


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
    }

    public static void maxCountExceededExceptionHandling(MaxCountExceededException e, FruitToStorageInfo fruitToStorageInfo, FruitStorage fruitStorage) {
        if (e.getNumberOfEmptySlots() == 0) {
            throw new RuntimeException();
        }
        fruitToStorageInfo.setCount(e.getNumberOfEmptySlots());
        try {
            System.out.println(fruitStorage.addToStorage(fruitToStorageInfo));
        } catch (MaxCountExceededException ex) {
            throw new RuntimeException(ex);
        }
    }
}


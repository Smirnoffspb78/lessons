package com.smirnov.project.lesson15.homework15;

import java.util.Comparator;

import static com.smirnov.project.lesson15.homework15.FruitToStorageInfo.FruitType.*;

public class Main {
    public static void main(String[] args) {
        FruitToStorageInfo fruitToStorageInfo = new FruitToStorageInfo(BANANA, 100, 10);
        FruitToStorageInfo fruitToStorageInfo1 = new FruitToStorageInfo(APRICOT, 100, 10);
        FruitToStorageInfo fruitToStorageInfo2 = fruitToStorageInfo1;
        FruitToStorageInfo fruitToStorageInfo3 = new FruitToStorageInfo(APRICOT, 125, 10);
        FruitToStorageInfo fruitToStorageInfo4 = new FruitToStorageInfo(BANANA, 95, 5);
        FruitToStorageInfo fruitToStorageInfo5 = new FruitToStorageInfo(APPLE, 95, 5);

        FruitStorage fruitStorage = new FruitStorage(33);


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

        Comparator<FruitToStorageInfo> comparatorOfNumber = new ComparatorsFruits.NumberOfFruits();
        System.out.println("Отсортированный склад по количеству фруктов: " + fruitStorage.compareFruit(comparatorOfNumber));

        System.out.println("Отсортированный склад по количеству фруктов функцией: " +
                fruitStorage.compareFruit((fruit1, fruit2) -> (fruit2.getCount() - fruit1.getCount())));

        System.out.println("Отсортированный склад по количеству фруктов с помощью дефолтного метода: " +
                fruitStorage.compareFruit(Comparator.comparingInt(FruitToStorageInfo::getCount).reversed()));


        Comparator<FruitToStorageInfo> comparatorType = new ComparatorsFruits.TypeOfFruit();
        System.out.println("Отсортированный склад по типу" + fruitStorage.compareFruit(comparatorType));

        System.out.println("Отсортированный склад по типу с помощью функции"
                + fruitStorage.compareFruit((fruit1, fruit2) -> fruit2.getType().compareTo(fruit1.getType())));

        System.out.println("Отсортированный склад по типу с помощью дефолтного метода"
                + fruitStorage.compareFruit(Comparator.comparing(FruitToStorageInfo::getType)));

        Comparator<FruitToStorageInfo> comparatorPrice = new ComparatorsFruits.PriceOfFruit();
        System.out.println("Отсортированный склад по стоимости" + fruitStorage.compareFruit(comparatorPrice));

        System.out.println("Отсортированный склад по стоимости с помощью функции"
                + fruitStorage.compareFruit((fruit1, fruit2)-> Double.compare(fruit1.getPrice(), fruit2.getPrice())));

        System.out.println("Отсортированный склад по стоимости с помощью дефолтного метода"
                + fruitStorage.compareFruit(Comparator.comparingDouble(FruitToStorageInfo::getPrice)));


        Comparator<FruitToStorageInfo> comparatorNumberAndPrice = new ComparatorsFruits.NumberAndPriceFruit();
        System.out.println("Склад, отсортированный пок количеству по возрастанию и по убыванию цены" + fruitStorage.compareFruit(comparatorNumberAndPrice));

        System.out.println("Склад, отсортированный пок количеству по возрастанию и по убыванию цены"
                + fruitStorage.compareFruit((fruit1, fruit2)->{
            if (fruit1.getCount() == fruit2.getCount()) {
                return Double.compare(fruit2.getPrice(), fruit1.getPrice());
            }
            return fruit1.getCount() - fruit2.getCount();
        }));

        Comparator comparatorOfCount=Comparator.comparingInt(FruitToStorageInfo::getCount);
        Comparator comparatorOfPrice=Comparator.comparingDouble(FruitToStorageInfo::getPrice).reversed();

        System.out.println("Склад, отсортированный пок количеству по возрастанию и по убыванию цены c помощью дефолтного метода"
                + fruitStorage.compareFruit(comparatorOfCount.thenComparing(comparatorOfPrice)));}



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


package com.smirnov.project.lesson15.homework15;

import static com.smirnov.project.lesson15.homework15.FruitToStorageInfo.FruitType.*;

public class Main {
    public static void main(String[] args) {
        FruitToStorageInfo fruitToStorageInfo=new FruitToStorageInfo(BANANA, 100, 5);
        FruitToStorageInfo fruitToStorageInfo1=new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo3=new FruitToStorageInfo(APRICOT, 100, 5);
        FruitToStorageInfo fruitToStorageInfo4=new FruitToStorageInfo(BANANA, 95, 5);
        FruitToStorageInfo fruitToStorageInfo5=new FruitToStorageInfo(APPLE, 95, 5);

        FruitStorage fruitStorage = new FruitStorage(18);

        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo)); //true 5
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo1)); //true 10
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo3)); //true  15
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo4)); //true 20
        System.out.println(fruitStorage.addToStorage(fruitToStorageInfo5)); //false 20
        System.out.println(fruitStorage);
        System.out.println("Количество свободных мест: "+fruitStorage.getNumberOfEmptySlots());

        System.out.println("Количество фруктов определенного типа: "+fruitStorage.getNumberOfFruitsByType(BANANA));

        System.out.println("Бананы с ценой не выше 99: "+fruitStorage.getFruitsByTypeAndPrice(BANANA, 50));
        System.out.println("Бананы с ценой не выше 99: "+fruitStorage.getFruitsByTypeAndPrice(BANANA, 99));
        System.out.println("Бананы с ценой не выше 100: "+fruitStorage.getFruitsByTypeAndPrice(BANANA, 100));
        System.out.println("Минимальная цена бананов: "+fruitStorage.getMinPriceByType(BANANA));
        System.out.println("Минимальная цена яблок: "+fruitStorage.getMinPriceByType(APPLE));
        fruitStorage.increasePrice(10);
        System.out.println("Коллекция после изменения цены"+fruitStorage);

        //Изменение доступного объекта fruitToStorageInfo извне не приводит к изменению объектов коллекции
        //Иначе бы возможна была такая ситуация, что фруктов оказалось больше, чем свободного места
        fruitToStorageInfo.setCount(20);
        System.out.println(fruitToStorageInfo);
        System.out.println(fruitStorage);


    }
}

package com.smirnov.project.lesson08.homework8.task2;

public class ListOfApprovedProduct {
    public static void main(String[] args) {
        MyAllowedProduct checkProduct = new MyAllowedProduct(300, 300, 300, 300);
        Product bread = new Product("Хлеб", 0.1, 23.5, 3.4, 11.3);
        boolean breadCheck = checkProduct.checkAllowedProduct(bread);
        Product pig = new Product("Свинина", 448, 11.6, 49.7);
        boolean checkPig = checkProduct.checkAllowedProduct(pig);
        Product vegetableOil = new Product("Растительно масло", 898, 99.8);
        boolean checkVegetableOil = checkProduct.checkAllowedProduct(vegetableOil);
        Product tomato = new Product("Томаты", 19, 0.7, 0, 3.1);
        boolean checkTomato = checkProduct.checkAllowedProduct(tomato);
    }
}

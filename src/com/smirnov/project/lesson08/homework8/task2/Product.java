package com.smirnov.project.lesson08.homework8.task2;

/**
 * Класс, характеризующий соедржание в продуктах белков, жиров, углеводов и каллорий
 */
public class Product {
    /**
     * Название продукта.
     */
    private String nameProduct;
    /**
     * Количество белков.
     */
    private double squirrels;
    /**
     * Количество жиров.
     */
    private double fats;
    /**
     * Количество углеводов.
     */
    private double carbohydrates;
    /**
     * Количество калорий, [Ккал/100г].
     */
    private double calories;

    /**
     * Вспомогательный конструктор, который создает имя продукта и количество каллорий.
     *
     * @param nameProduct Наименование продукта
     * @param calories    Калории
     */
    private Product(String nameProduct, double calories) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Наименование продукта не может быть пустым или быть null.");
        }
        this.nameProduct = nameProduct;
        this.calories = checkValueCharacterProduct(calories);
    }

    /**
     * Конструктор, создающий объект с парматерами.
     *
     * @param nameProduct   Наименование продукта
     * @param calories      Калории
     * @param squirrels     Белки
     * @param fats          Жиры
     * @param carbohydrates Углеводы
     */
    public Product(String nameProduct, double calories, double squirrels, double fats,
                   double carbohydrates) {
        this(nameProduct, calories);
        this.squirrels = checkValueCharacterProduct(squirrels);
        this.fats = checkValueCharacterProduct(fats);
        this.carbohydrates = checkValueCharacterProduct(carbohydrates);
    }

    /**
     * Конструктор, создающий объект с парматерами.
     *
     * @param nameProduct Наименование продукта
     * @param calories    Калории
     * @param squirrels   Белки
     * @param fats        Жиры
     */
    public Product(String nameProduct, double calories, double squirrels, double fats) {
        this(nameProduct, calories);
        this.squirrels = checkValueCharacterProduct(squirrels);
        this.fats = checkValueCharacterProduct(fats);
    }

    /**
     * Конструктор, создающий объект с парматерами.
     *
     * @param nameProduct Наименование продукта
     * @param calories    Калории
     * @param fats        Жиры
     */
    public Product(String nameProduct, double calories, double fats) {
        this(nameProduct, calories);
        this.fats = fats;
    }

    /**
     * Вспомогательный метод, проверяющий правильность введенных значений белков, жиров, углеводов и калорий
     *
     * @param characterProduct Один из парметров продукта: белки, жиры, углеводы или калории
     * @return Значение введенного продукта
     * @throws IllegalArgumentException если характеристика продукта отрицательная
     */
    private static double checkValueCharacterProduct(double characterProduct) {
        if (characterProduct < 0) {
            throw new IllegalArgumentException("Характеристики продукта не могут быть ортицательными");
        }
        return characterProduct;
    }

    public double getCalories() {
        return calories;
    }

    public double getSquirrels() {
        return squirrels;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public String getNameProduct() {
        return nameProduct;
    }

}

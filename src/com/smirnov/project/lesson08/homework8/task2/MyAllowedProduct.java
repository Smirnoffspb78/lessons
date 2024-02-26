package com.smirnov.project.lesson08.homework8.task2;

/**
 * Класс допустимых значений белков, жиров, углеводов, калорий
 */
public class MyAllowedProduct {
    /**
     * Максимально допустимое количество белков.
     */
    private double maxSquirrels;
    /**
     * Максимально допустимое количество жиров.
     */
    private double maxFats;
    /**
     * Максимально допустимое количество углеводов.
     */
    private double maxCarbohydrates;
    /**
     * Максимально допустимое количество калорий, [Ккал/100г].
     */
    private double maxCalories;

    /**
     * Вспомогательный метод, проверяющий правильность введенных занчений продукта.
     *
     * @param characterProduct Допустимое значение белков, жиров, углеводов или каллорий;
     * @return Допустимое значение продукта или 0, если characterProduct<0.
     */
    private double checkValueCharacterProduct(double characterProduct) {
        if (characterProduct < 0) {
            throw new IllegalArgumentException("Допустимые характеристики не могут быть отрицательными");
        }
        return characterProduct;
    }

    /**
     * Конструктор для создания объекта класса.
     *
     * @param maxSquirrels     - Максимально допустимые белки;
     * @param maxFats          - Максимально допустимые жиры;
     * @param maxCarbohydrates - Максимально допустимые углеводы;
     * @param maxCalories      - Максимально допустимые калории.
     */
    public MyAllowedProduct(double maxCalories, double maxSquirrels, double maxFats, double maxCarbohydrates) {
        this.maxSquirrels = checkValueCharacterProduct(maxSquirrels);
        this.maxFats = checkValueCharacterProduct(maxFats);
        this.maxCarbohydrates = checkValueCharacterProduct(maxCarbohydrates);
        this.maxCalories = checkValueCharacterProduct(maxCalories);
    }

    /**
     * Метод, проверяющий допустимость к употреблению продукта.
     *
     * @param product ссылка на объект класса Product.
     * @return true/false в зависимости от того, превышает ли одна из характеритки продукта допустимы значения.
     * @see Product
     */
    public boolean checkAllowedProduct(Product product) {
        boolean checkProduct = maxCalories >= product.getCalories() && maxCarbohydrates >= product.getCarbohydrates()
                && maxFats >= product.getFats() && maxSquirrels >= product.getSquirrels();
        if (!checkProduct) {
            System.out.printf("%s не подходит к вашему рациону.%n", product.getNameProduct());
        }
        return checkProduct;
    }
    public double getMaxSquirrels() {
        return maxSquirrels;
    }

    public void setMaxSquirrels(double maxSquirrels) {
        this.maxSquirrels = checkValueCharacterProduct(maxSquirrels);
    }

    public double getMaxFats() {
        return maxFats;
    }

    public void setMaxFats(double maxFats) {
        this.maxFats = checkValueCharacterProduct(maxFats);
    }

    public double getMaxCarbohydrates() {
        return maxCarbohydrates;
    }

    public void setMaxCarbohydrates(double maxCarbohydrates) {
        this.maxCarbohydrates = checkValueCharacterProduct(maxCarbohydrates);
    }

    public double getMaxCalories() {
        return maxCalories;
    }

    public void setMaxCalories(double maxCalories) {
        this.maxCalories = checkValueCharacterProduct(maxCalories);
    }
}

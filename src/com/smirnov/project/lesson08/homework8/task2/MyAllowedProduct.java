package com.smirnov.project.lesson08.homework8.task2;

import java.util.logging.Logger;

public class MyAllowedProduct {
    private static final Logger LOGGER = Logger.getLogger(MyAllowedProduct.class.getName());
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
     * Максимально допустимое количество калорий.
     */
    private double maxCalories;

    private static final double ERROR_CHARACTER = 1.0 / 0;

    /**
     * Вспомогательный метод, проверяющий правильность введенных занчений продукта.
     *
     * @param characterProduct Допустимое значение белков, жиров, углеводов или каллорий;
     * @return Допустимое значение продукта или 0, если characterProduct<0.
     */
    private double checkValueCharacterProduct(double characterProduct) {
        if (characterProduct < 0 || characterProduct == ERROR_CHARACTER) {
            characterProduct = 0;
            LOGGER.warning("Проверьте правильность допустимых введенных значений продукта.");
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
            LOGGER.info("%s не подходит к вашему рациону.".formatted(product.getNameProduct()));
        }
        return checkProduct;
    }
}

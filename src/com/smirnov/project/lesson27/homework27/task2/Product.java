package com.smirnov.project.lesson27.homework27.task2;

import java.util.Objects;

/**
 * Продукт.
 *
 * @param id          Идентификатор продукта.
 * @param productName Наименование продукта.
 * @param price       Стоимость.
 * @param quantity    Количество.
 */
public record Product(int id, String productName, double price, int quantity) {

    public Product(int id, String productName, double price, int quantity) {
        if (price <= 0 || quantity < 0 || id < 0 || productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("quantity не должно быть отрицательным. price должно быть положительным");
        }
        this.id = id;
        this.productName = Objects.requireNonNull(productName);
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product product)) {
            return false;
        }

        if (id != product.id) {
            return false;
        }
        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{id=%d, quantity=%d}".formatted(id, quantity);
    }
}

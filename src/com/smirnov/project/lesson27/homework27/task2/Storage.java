package com.smirnov.project.lesson27.homework27.task2;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;

/**
 * Склад.
 */
public class Storage extends Thread {

    /**
     * Путь к файлу с товарами на складе.
     */
    private final String pathFile;
    /**
     * Список товаров.
     */
    private final List<Product> productsList = new ArrayList<>();

    /**
     * Конструктор создает склад со списком товаров.
     *
     * @param pathFile Путь к складу
     */
    public Storage(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void run() {
        try {
            newBufferedReader(Path.of(pathFile))
                    .lines()
                    .map(string -> string.split("::"))
                    .forEach(strings -> productsList.add(new Product(parseInt(strings[0]), strings[1], parseDouble(strings[2]), parseInt(strings[3]))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProductsList() {
        return productsList;
    }
}

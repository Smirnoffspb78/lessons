package com.smirnov.project.lesson27.homework27.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;

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
     * @param pathFile  Путь к складу
     */
    public Storage(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void run() {
        File storageInfo = new File(pathFile);
        try (Scanner scannerFile = new Scanner(storageInfo)) {
            if (scannerFile.hasNextLine()) {
                while (scannerFile.hasNextLine()) {
                    String[] lineString = scannerFile.nextLine().split("::");
                    Product product = new Product(parseInt(lineString[0]), lineString[1], parseDouble(lineString[2]), parseInt(lineString[3]));
                    productsList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
          out.println("Файл отсутствует");
        }
    }

public String getPathFile() {
    return pathFile;
}

public List<Product> getProductsList() {
    return productsList;
}
}

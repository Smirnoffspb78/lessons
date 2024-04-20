package com.smirnov.project.lesson27.homework27.task2;

<<<<<<< HEAD
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
>>>>>>> origin/HomeWork27

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
<<<<<<< HEAD
        try {
           newBufferedReader(Path.of(pathFile))
                    .lines()
                    .map(string -> string.split("::"))
                    .forEach(strings-> productsList.add(new Product(parseInt(strings[0]), strings[1], parseDouble(strings[2]), parseInt(strings[3]))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

=======
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

>>>>>>> origin/HomeWork27
public List<Product> getProductsList() {
    return productsList;
}
}

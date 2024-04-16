package com.smirnov.project.lesson27.homework27.task2;

import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import static java.lang.System.out;
import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

/**
 * Записывает в файл
 */
public class ThreadWrite extends Thread {
    /**
     * Склады
     */
    private final Storage[] storages;
    String pathSave ;


    /**
     * Конструктор создает объект для записи в потоке
     *
     * @param storages склады
     */
    public ThreadWrite(Storage[] storages, String pathSave) {
        this.storages = requireNonNull(storages);
        this.pathSave = requireNonNull(pathSave);
    }

    @Override
    public void run() {
        Arrays.stream(storages)
                .map(Storage::getProductsList).forEach(productsList -> productsList.stream()
                        .map(product -> "%d: %d\n".formatted(product.getId(), product.getQuantity()))
                        .forEach(temp -> {
                            try {
                                writeString(get(pathSave), temp,
                                        StandardOpenOption.CREATE,
                                        StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                out.println("Ошибка сохранения");
                            }
                        }));
    }
}

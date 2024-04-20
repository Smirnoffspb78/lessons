package com.smirnov.project.lesson27.homework27.task2;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Storage[] storages = new Storage[args.length];

        IntStream.range(0, args.length).forEach(i -> {
            storages[i] = new Storage(args[i]);
            storages[i].start();
        });

        Arrays.stream(storages).forEach(thread -> {
            try {
                thread.join(2000);
            } catch (InterruptedException e) {
                out.println("Поток умер");
            }
        });
        String pathSave = "StorageWrite.txt";
        ThreadWrite threadWrite = new ThreadWrite(storages, pathSave);
        threadWrite.setDaemon(true);
        threadWrite.start();
        Map<String, Set<Product>> productMap = new HashMap<>();
        ;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < storages[i].getProductsList().size(); j++) {
                Product product = storages[i].getProductsList().get(j);
                productMap.putIfAbsent(product.productName(), new TreeSet<>(Comparator.comparingDouble(Product::price)));
                /*productMap.computeIfAbsent(product.productName(), ()->new TreeSet<>(Comparator.comparingDouble(Product::price)).add(product));*/
                productMap.get(product.productName()).add(product);
            }
        }
        try {
            threadWrite.join(5000);
        } catch (InterruptedException e) {
            out.println("Поток в режиме ожидания");
        }
    }
}



package com.smirnov.project.lesson27.homework27.task2;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Storage[] storages = new Storage[args.length];
        Thread[] threads = new Thread[args.length];
        IntStream.range(0, args.length).forEach(i -> {
            storages[i] = new Storage(args[i]);
            threads[i] = new Thread(storages[i]);
            threads[i].start();
        });

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join(2000);
            } catch (InterruptedException e) {
                out.println("Поток умер");
            }
        });

        String pathSave="C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/lesson27/homework27/task2/StorageWrite.txt";
        Thread daemonThread = new Thread(new ThreadWrite(storages, pathSave));
        daemonThread.setDaemon(true);
        daemonThread.start();

        Map<String, Set<Product>> productMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < storages[i].getProductsList().size(); j++) {
                Product product = storages[i].getProductsList().get(j);
                if (!productMap.containsKey(product.getProductName())) {
                    Set<Product> productSet = new TreeSet<>(Comparator.comparingDouble(Product::getPrice));
                    productSet.add(product);
                    productMap.put(product.getProductName(), productSet);
                } else {
                    productMap.get(product.getProductName()).add(product);
                }
            }
        }
        try {
            daemonThread.join(5000);
        } catch (InterruptedException e) {
            out.println("Поток умер");
        }
    }
}



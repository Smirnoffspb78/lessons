package com.smirnov.project.lesson29.homework29;

import java.io.IOException;
import java.nio.file.Path;

import static java.lang.System.out;
import static java.nio.file.Files.newBufferedReader;

public class Main {
    public static void main(String[] args) {
        try {
            long run = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            newBufferedReader(Path.of(args[0]))
                         .lines()
                         .forEach(stringBuilder::append) ;
                HomeWork17.topTenWords(stringBuilder.toString());
                long difference = System.currentTimeMillis() - run;
                out.println("\nВремя выполнения: " + difference);
        } catch (IOException e) {
            out.println("Нет доступа к файлу");
        } finally {

        }
    }
}

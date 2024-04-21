package com.smirnov.project.lesson29.homework29;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Path.of;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> textList = readAllLines(of(args[0]));
            StringBuilder stringBuilder = new StringBuilder();
            textList.forEach(stringBuilder::append);
            HomeWork17.topTenWords(stringBuilder.toString());
        } catch (IOException e) {
            out.println("Нет доступа к файлу");
        }
    }
}

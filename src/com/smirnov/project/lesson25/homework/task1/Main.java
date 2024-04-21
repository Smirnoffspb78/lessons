package com.smirnov.project.lesson25.homework.task1;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        byte btest = 95;
        byte key = 22;
        byte res = (byte) (key ^ btest);
        System.out.println(res);

        byte reserrev = (byte) (key ^ res);
        System.out.println(reserrev);


        String path = "C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/lesson25/HomeWork/Task1/TaskFile.txt";

        InputStream inputStream = new InputDecorator(new FileInputStream(path));

        try {
            inputStream.read();
            System.out.println(Arrays.toString(((InputDecorator) inputStream).getFileInByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String pathOut = "C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/lesson25/HomeWork/Task1/TaskFileOut.txt";
        OutputStream outputStream = new OutputDecorator(new FileOutputStream(pathOut));

        try {
            outputStream.write(((InputDecorator) inputStream).getFileInByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

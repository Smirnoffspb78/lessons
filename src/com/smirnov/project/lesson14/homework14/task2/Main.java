package com.smirnov.project.lesson14.homework14.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0}; //2+4=6; 1+3+5=9

        PairContainer<Double> pairContainer=PairContainer.generatePairContainer(doubles);
        System.out.println(pairContainer);
        Double key1d=pairContainer.getSumOfEvenNumbers();
        Double key2d=pairContainer.getSumOfOddNumbers();
        System.out.println("1: "+key1d+"  2: "+key2d);

        Integer[] integers = {1, 2, 3, 4, 5};
        PairContainer<Integer> pairContainer1=PairContainer.generatePairContainer(integers);
        System.out.println(pairContainer1);
        Integer key1=pairContainer1.getSumOfEvenNumbers();
        Integer key2=pairContainer1.getSumOfOddNumbers();
        System.out.println("1: "+key1+"  2: "+key2);

        Double[] doubles1=new Double[0];
        System.out.println(Arrays.toString(doubles1));
        PairContainer<Double> pairContainer2=PairContainer.generatePairContainer(doubles1);
        System.out.println(pairContainer2);
    }
}

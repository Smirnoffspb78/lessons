package com.smirnov.project.lesson14.homework14.task2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0}; //2+4=6; 1+3+5=9

        ReturnPairContainer<Double> ret = new ReturnPairContainer<>();
        System.out.println(ret.returnPairContainer(doubles));

        Integer[] integers = {1, 2, 3, 4, 5};
        ReturnPairContainer<Integer> ret1 = new ReturnPairContainer<>();
        System.out.println(ret1.returnPairContainer(integers));


        BigDecimal[] bigDecimals={BigDecimal.valueOf(1),BigDecimal.valueOf(1),BigDecimal.valueOf(2),BigDecimal.valueOf(3)};

    }
}

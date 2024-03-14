package com.smirnov.project.lesson14.homework14.task2;

/**
 * Контейнер, хранящий пару ключей
 *
 * @param <T> Number
 * @param sumOfEvenNumbers Ключ №1.
 * @param sumOfOddNumbers  Ключ №2.
 */
public record PairContainer<T extends Number>(T sumOfEvenNumbers, T sumOfOddNumbers) {

    /**
     * Конструктор создает контейнер.
     *
     * @param sumOfEvenNumbers Ключ №1
     * @param sumOfOddNumbers  Ключ №2
     */
    public PairContainer {
        if (sumOfEvenNumbers == null || sumOfOddNumbers == null) {
            throw new NullPointerException("SumOfEvenNumbers=null, SumOfOddNumbers=null");
        }
    }

    @Override
    public String toString() {
        return "Cумма четных числе: %s, Сумма нечетных чисел: %s".formatted(sumOfEvenNumbers, sumOfOddNumbers);
    }
}

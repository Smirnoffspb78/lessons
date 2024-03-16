package com.smirnov.project.lesson14.homework14.task2;

/**
 * Контейнер, хранящий пару ключей.
 */
public final class PairContainer<T extends Number> {
    private final T sumOfEvenNumbers;
    private final T sumOfOddNumbers;


    /**
     * Конструктор создает контейнер.
     *
     * @param sumOfEvenNumbers Ключ №1
     * @param sumOfOddNumbers  Ключ №2
     */
    private PairContainer(T sumOfEvenNumbers, T sumOfOddNumbers) {
        if (sumOfEvenNumbers == null || sumOfOddNumbers == null) {
            throw new NullPointerException("SumOfEvenNumbers=null, SumOfOddNumbers=null");
        }
        this.sumOfEvenNumbers = sumOfEvenNumbers;
        this.sumOfOddNumbers = sumOfOddNumbers;
    }

    /**
     * Добавляет в контейнер ключ1 - сумма четных чисел, в контейнер 2 - сумма нечетных чисел.
     *
     * @param arr Массив чисел
     * @return Контейнер с ключами
     */
    public static <T extends Number> PairContainer<T> generatePairContainer(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("arr=null");
        }
        if (arr.length == 0) {
            return (PairContainer<T>) new PairContainer<>(0, 0);
        }
        double sumOfEvenNumbers = 0.0;
        double sumOfOddNumbers = 0.0;
        for (T t : arr) {
            if (t == null) throw new NullPointerException("arr[i]=null");
            if ((t.doubleValue() % 2) == 0) {
                sumOfEvenNumbers += t.doubleValue();
            } else {
                sumOfOddNumbers += t.doubleValue();
            }
        }

        if (arr[0] instanceof Byte) {
            return (PairContainer<T>) new PairContainer<>((byte) sumOfEvenNumbers, (byte) sumOfOddNumbers);
        } else if (arr[0] instanceof Integer) {
            return (PairContainer<T>) new PairContainer<>((int) sumOfEvenNumbers, (int) sumOfOddNumbers);
        } else if (arr[0] instanceof Long) {
            return (PairContainer<T>) new PairContainer<>((long) sumOfEvenNumbers, (long) sumOfOddNumbers);
        } else if (arr[0] instanceof Short) {
            return (PairContainer<T>) new PairContainer<>((short) sumOfEvenNumbers, (short) sumOfOddNumbers);
        } else if (arr[0] instanceof Float) {
            return (PairContainer<T>) new PairContainer<>((float) sumOfEvenNumbers, (float) sumOfOddNumbers);
        }
        return (PairContainer<T>) new PairContainer<>(sumOfEvenNumbers, sumOfOddNumbers);
    }

    @Override
    public String toString() {
        return "Cумма четных числе: %s, Сумма нечетных чисел: %s".formatted(sumOfEvenNumbers, sumOfOddNumbers);
    }

    public T getSumOfEvenNumbers() {
        return sumOfEvenNumbers;
    }

    public T getSumOfOddNumbers() {
        return sumOfOddNumbers;
    }
}

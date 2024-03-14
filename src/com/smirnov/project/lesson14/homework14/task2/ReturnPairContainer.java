package com.smirnov.project.lesson14.homework14.task2;

/**
 * Создает контейнер.
 * @param <T>
 */
public class ReturnPairContainer<T extends Number> {
    /**
     * Добавляет в контейнер ключ1 - сумма четных чисел, в контейнер 2 - сумма нечетных чисел.
     * @param arr Массив чисел
     * @return Контейнер с ключами
     */
    public PairContainer<T> returnPairContainer(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("arr=null");
        }
        Number sumOfEvenNumbers = 0;
        Number sumOfOddNumbers = 0;
        Number temp;
        for (T t : arr) {
            if (t == null) throw new NullPointerException("arr[i]=null");
            temp = t.doubleValue() % 2;
            sumOfEvenNumbers = temp.equals(0.0) ? t.doubleValue() + sumOfEvenNumbers.doubleValue() : sumOfEvenNumbers;
            sumOfOddNumbers = !temp.equals(0.0) ? t.doubleValue() + sumOfOddNumbers.doubleValue() : sumOfOddNumbers;
        }
        return (PairContainer<T>) new PairContainer<>(sumOfEvenNumbers, sumOfOddNumbers);
    }
}

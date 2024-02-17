package lesson06;

import java.util.Arrays;

public class HomeWork06 {
    public static void main(String[] args) {
        /**Прочитать и реализовать пузырьковый метод
         */
        int[] arrayForBubbleMethod = {9, 2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("Остортированный массив пузырьковым методом" + Arrays.toString(BubbleMethod.bubbleMethod(arrayForBubbleMethod)));

        /**Дан массив целых чисел: `int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44}`. Найти максимальную сумму четырёх смежных целых
         чисел в массиве task02. Использовать алгоритм скользящего окна.*/
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};
        System.out.println("Максимальная сумма четрех смежных чисел: " + SlidingWindow.slidingWindow(task02));
    }
}

package lesson06;

import static lesson06.BubbleMethod.bubbleMethod;
import static lesson06.SlidingWindow.slidingWindow;

public class HomeWork06 {
    public static void main(String[] args) {
        /**Прочитать и реализовать пузырьковый метод
         */
        int[] arrayForBubbleMethod = {5, 2, 3, 4};
        bubbleMethod(arrayForBubbleMethod);

        /**Дан массив целых чисел: `int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44}`. Найти максимальную сумму четырёх смежных целых
         чисел в массиве task02. Использовать алгоритм скользящего окна.*/
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};
        slidingWindow(task02);
    }
}

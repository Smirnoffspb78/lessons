package lesson06;

import java.util.Arrays;

import static lesson06.BubbleMethod.bubbleMethod;
import static lesson06.SlidingWindow.slidingWindow;

public class HomeWork06 {
    public static void main(String[] args) {
        /**Прочитать и реализовать пузырьковый метод
         */
        int[] arrayForBubbleMethod = {5, 2, 3, 4};
        int[] sortedArray;
        if (arrayForBubbleMethod == null) {
            System.out.println("В метод sortedArray передан null");
            sortedArray = new int[1];
        } else {
            sortedArray = new int[arrayForBubbleMethod.length];
            System.arraycopy(arrayForBubbleMethod, 0, sortedArray, 0, arrayForBubbleMethod.length);
        }
        bubbleMethod(sortedArray);
        System.out.println(Arrays.toString(sortedArray));

        /**Дан массив целых чисел: `int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44}`. Найти максимальную сумму четырёх смежных целых
         чисел в массиве task02. Использовать алгоритм скользящего окна.*/
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};
        if (task02 == null) {
            System.out.println("В метод SlidingWindow пердан null");
            int[] exeptionArray = new int[3];
            System.out.println(slidingWindow(exeptionArray));
        } else {
            System.out.println(slidingWindow(task02));
        }
    }
}

package lesson07;

import static lesson07.SortingUniqueItems.*;
import static lesson07.TargetSumOfTwoNumbers.targetSumOfTwoNumbers;

public class HomeWork7 {
    public static void main(String[] args) {
        /**
         * 1. Дан массив целых чисел и целочисленная переменная (target).
         *  Найти и вывести в консоль два элемента массива, которые в сумме дают target.
         */
        int[] arr = {4, 7, 3, 5, 1, 8};
        int target = 10;
        int[] resultTusk1 = targetSumOfTwoNumbers(target, arr);
        /**
         * 2. Дан массив целых чисел. Изменить его таким образом, чтобы вначале
         * стояли только уникальные элементы (порядок следования элементов менять нельзя).
         */
        int[] arr2 = {15, 3, 3, 4, 4, 3, 3, 3, 3, 5, 0};
        int[] resultSortingUniqueItems = sortingUniqueItems(arr2);
        int[] uniqueSortingWithThreeCycles = uniqueSortingWithThreeCycles(arr2);
        int[] uniqueSortingWithCollection = uniqueSortingWithCollection(arr2);
        int[] uniqueSortingWithTwoArray=uniqueSortingWithTwoArray(arr2);
        int[] uniqueSortingWithIndex=uniqueSortingWithIndex(arr2);
    }
}

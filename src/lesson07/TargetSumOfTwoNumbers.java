package lesson07;

import java.util.Arrays;
import java.util.logging.Logger;


/**
 * Класс, реализующий метод, который возвращает 2 числа, дающих целевую сумму
 */
public class TargetSumOfTwoNumbers {
    private TargetSumOfTwoNumbers() {
    }

    private static final Logger LOGGER = Logger.getLogger(TargetSumOfTwoNumbers.class.getName());

    public static int[] targetSumOfTwoNumbers(int target, int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод targetSumOfTwoNumbers передан null");
            return new int[2];
        } else if (arr.length < 2) {
            LOGGER.warning("В метод targetSumOfTwoNumbers передеан массив длинной меньше 2");
            return new int[2];
        }
        int[] result = new int[2];
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        var leftPointer = 0;
        var rightPointer = sortedArray.length - 1;
        var checkMoreTarget = sortedArray[rightPointer] + sortedArray[rightPointer - 1] >= target;
        var check = true;
        if (!checkMoreTarget) {
            LOGGER.info("Массив не содержит чисел, дающих %d".formatted(target));
            return new int[2];
        }
        while (leftPointer < rightPointer && check) {
            if (sortedArray[leftPointer] + sortedArray[rightPointer] == target) {
                check = false;
                result[0] = sortedArray[leftPointer];
                result[1] = sortedArray[rightPointer];
            } else if (sortedArray[leftPointer] + sortedArray[rightPointer] < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        if (!check) {
            LOGGER.info("Два числа, дающих %d: %s".formatted(target, Arrays.toString(result)));
            return result;
        } else {
            LOGGER.info("Массив не содержит чисел, дающих %d".formatted(target));
            return new int[2];
        }
    }
}

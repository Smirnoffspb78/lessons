package lesson06;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Класс, реализующий пузырьковый метод сортировки массива
 */
public class BubbleMethod {
    private BubbleMethod() {
    }

    private static final Logger LOGGER = Logger.getLogger(BubbleMethod.class.getName());

    public static int[] bubbleMethod(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод bubbleMethod передан null");
            return new int[1];
        } else {
            var count = 0;
            int temp;
            boolean check = true;
            int[] sortedArray = arr.clone();
            while (check) {
                check = false;
                for (int j = 0; j < sortedArray.length - count - 1; j++) {
                    if (sortedArray[j] > sortedArray[j + 1]) {
                        temp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = temp;
                        check = true;
                    }
                }
                count++;
            }
            String message = "Отсортированный массив " + Arrays.toString(sortedArray);
            LOGGER.info(message);
            return sortedArray;
        }
    }
}

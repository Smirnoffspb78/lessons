package lesson06;

import java.util.logging.Logger;

import static java.lang.Math.max;

/**
 * Класс, реализующий метод скользящего окна для четырех элементов массива
 */
public class SlidingWindow {
    private SlidingWindow() {
    }

    private static final Logger LOGGER = Logger.getLogger(SlidingWindow.class.getName());
    public static final int NUMBER = 4; //Число элементов массива, для поиска максимума

    public static int slidingWindow(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод slidingWindow передан null");
            return 0;
        } else if (arr.length < NUMBER) {
            LOGGER.warning("В метод slidingWindow передан массив с длинной меньше " + NUMBER);
            return 0;
        } else {
            var maxSumma = 0;
            for (int i = 0; i < arr.length; i++) {
                maxSumma = i < NUMBER ? maxSumma + arr[i] : max(maxSumma, maxSumma - arr[i - NUMBER] + arr[i]);
            }
            String message = "Максимальная сумма четырех чисел: " + maxSumma;
            LOGGER.info(message);
            return maxSumma;
        }
    }
}

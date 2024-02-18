package lesson06;

import static java.lang.Math.max;

public class SlidingWindow {
    private SlidingWindow() {
    }

    public static int slidingWindow(int[] arr) {
        if (arr.length<4){
            System.out.println("В метод SlidingWindow передан некорректный массив");
            return 0;
        }
        else {
        var maxSumma = 0;
        final var number = 4;
        for (int i = 0; i < arr.length; i++) {
            maxSumma = i < number ? maxSumma + arr[i] : max(maxSumma, maxSumma - arr[i - number] + arr[i]);
        }
        System.out.print("Максимальная сумма четырех чисел: ");
        return maxSumma;}
    }
}

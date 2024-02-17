package lesson06;

public class SlidingWindow {
    private SlidingWindow() {
    }

    public static int slidingWindow(int[] arr) {
        var number = 4;
        var maxSumma = 0;
        for (int i = 0; i < number; i++) {
            maxSumma += arr[i];
        }
        for (int i = number; i < arr.length; i++) {
            maxSumma = Math.max(maxSumma, maxSumma - arr[i - number] + arr[i]);
        }
        return maxSumma;
    }
}

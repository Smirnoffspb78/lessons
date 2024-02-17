package lesson06;

public class BubbleMethod {
    private BubbleMethod() {
    }

    public static int[] bubbleMethod(int[] arr) {
        var count = 0;
        int temp;
        boolean check;
        for (int i = 0; i < arr.length; i++) {
            check = true;
            for (int j = 0; j < arr.length - count - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    check = false;
                }
            }
            if (check) {
                break;
            }
            count++;
        }
        return arr;
    }
}

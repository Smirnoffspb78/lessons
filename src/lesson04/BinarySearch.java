package lesson04;

import java.util.Scanner;

public class BinarySearch {
    private BinarySearch() {
    }

    public static int binarySearchInt() {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        int rightNumber = 101;
        int leftNumber = 0;
        int programNumber = 50;
        System.out.println("Придумайте цклое число от 1 до 100");
        while (rightNumber != leftNumber + 2) {
            System.out.println("Чило равно " + programNumber + "?\n1 - Да\n0 - Нет");
            userInput = scanner.nextInt();
            if (userInput == 0) {
                System.out.println("Число больше, чем " + programNumber + "?\n1 - Да\n0 - Нет");
                userInput = scanner.nextInt();
                if (userInput == 1) {
                    leftNumber = programNumber;
                    programNumber += (rightNumber - leftNumber) / 2;
                } else if (userInput == 0) {
                    rightNumber = programNumber;
                    programNumber -= (rightNumber - leftNumber) / 2;
                } else {
                    System.out.println("Неверная подсказка");
                }
            } else if (userInput == 1) {
                break;
            } else {
                System.out.println("Неверная подсказка");
            }
        }
        return programNumber;
    }
}

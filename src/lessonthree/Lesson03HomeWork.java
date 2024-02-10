package lessonthree;

public class Lesson03HomeWork {
    public static void main(String[] args) {
        /*Задача #1 на Math.random() и ветвление
        Самостоятельно изучить Math.random() для генерации псевдослучайных чисел.
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500] в интервал (25;200) и выводить результат в консоль.
        Примеры работы программы: Число 345 не содержится в интервале (25;200) Число 110 содержится в интервале (25;200)*/
        var random = Math.random() * 491 + 10;
        System.out.print("Задание 1\nЧисло "+random);
        random = random > 500 ? 500 : random;
        if (random > 25 && random < 200) System.out.println(" попало в интервал (25; 200)");
        else System.out.println(" не попало в интервал (25; 200)");


      /*  Задача #2 на if else
        Даны переменные x и y - координаты точки на плоскости.
                Необходимо определить четверть координатной плоскости, которой принадлежит данная точка. Результат вывести в консоль.
        Если обе координаты положительны, точка принадлежит первой четверти.
                Если координата x отрицательна, а y положительна, точка принадлежит второй четверти.
                Если обе координаты отрицательны, точка принадлежит третьей четверти.
                Если координата x положительна, а y отрицательна, точка принадлежит четвёртой четверти.*/
        System.out.println("\nЗадание 2");
        int coordinateX = 10;
        int coordinateY = -20;
        if (coordinateX > 0 && coordinateY > 0) System.out.println("Точка принадлежит первой четверти");
        else if (coordinateX < 0 && coordinateY > 0) System.out.println("Точка принадлежит второй четверти");
        else if (coordinateX < 0 && coordinateY < 0) System.out.println("Точка принадлжеит третьей четверти");
        else if (coordinateX > 0 && coordinateY < 0) System.out.println("Точка принадлежит четвертой четверти");
        else System.out.println("Точка не принадлежит ни одной четверти");

        /* Задача #3 на switch
        Дана переменная monthNumber, которая хранит порядковый номера месяца. И переменная isLeap, которая хранит информацию о том, является ли год високосным.

                Написать программу, которая в зависимости от значения monthNumber выводит в консоль количество дней в этом месяце. Необходимо рассмотреть два случая: год не является високосным и год является високосным.*/
        System.out.println("\nЗадание 3");
        int monthNumber = 2;
        int numberOfDayInYear = 366;
        if (numberOfDayInYear == 365 || numberOfDayInYear == 366) {
            System.out.print("Количество дней в месяце ");
            switch (monthNumber) {
                case 1, 3, 5, 7, 8, 10, 12 -> System.out.println(31);
                case 4, 6, 9, 11 -> System.out.println(30);
                case 2 -> {
                    if (numberOfDayInYear == 365) System.out.println(28);
                    else if (numberOfDayInYear == 366) System.out.println(29);
                }
                default -> System.out.println("Неверно введен номер месяца");
            }
        } else System.out.println("Неверное количество дней в году");

        /*  Задача #4 на switch
        Даны переменные couponNumber - номер купона и resultSum - сумма покупки.
                Если номер купона - 1111, 4444 или 9999 - скидка 10%,
                Если номер купона - 3333 или 7777 - скидка 20%,
                Если номер купона - 5555 - скидка 30%.
        В остальных случаях скидка не предусмотрена.
        Необходимо вычислить и сохранить в переменную resultSum сумму с учетом скидки, если она предусмотрена. Вывести значение resultSum в консоль.*/
        int couponNumber = 5555;
        double resultSum = 157.5;
        resultSum = switch (couponNumber) {
            case 1111, 4444, 9999 -> 0.9 * resultSum;
            case 3333, 7777 -> 0.8 * resultSum;
            case 5555 -> 0.7 * resultSum;
            default -> resultSum;
        };
        System.out.println("\nЗадание 4 \nСумма покупки " + resultSum);
    }
}

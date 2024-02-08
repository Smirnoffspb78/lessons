package lesson02;
public class Lesson02HomeWork {
    //Комментарий
    public static void main(String[] args) {
        /* 1. объявите переменные для хранения информации об общем количестве писем и о количестве отправленных писем.
          Присвойте значения этим переменным. Выведите в консоль, сколько писем осталось отправить.
         */
        int totalNumberOfEmails = 10000;
        int numberOfEmailSent = 2000;
        System.out.println("Задание 1 \nОсталось отправить " + (totalNumberOfEmails - numberOfEmailSent) + " писем \n");
        /*2. Объявить и инициализировать переменные для хранения времени (в часах) и расстояния (в километрах).
        Найти и вывести в консоль скорость, выраженную в метрах в секунду.
         */
        double timeInHour = 2.5;
        double distanceInKilometers = 200.5;
        double velocityMeterInSecond = (distanceInKilometers * 1000) / timeInHour / 3600;
        System.out.println("Задание 2 \nСкорость движения " + velocityMeterInSecond + " м/сек\n");
        //3. Найти сумму цифр целого положительного двузначного числа. Результат вывести в консоль.
        int positiveInteger = 97;
        int sumOfTheNumber = positiveInteger / 10 + positiveInteger - positiveInteger / 10 * 10;
        System.out.println("Задание 3 \nСумма цифр положительного двузначного числа " + sumOfTheNumber + "\n");
        //4. Поменять значения 2х переменных местами, используя арифметические операторы. Результат вывести в консоль.
        double var1 = 0;
        double var2 = 10;
        var1=var2-var1;
        var2=var2-var1;
        var1=var1+var2;
        System.out.println("Задание 4 \nvar2=" + var2 + "\n" + "var1=" + var1 + "\n");

        //5. Разобрать, как работает оператор остаток от деления '%'
        double remainderOfDivision = 10 % 3.33;
        System.out.println("Задание 5 \nОстаток от деления возвращает значение, которое является разницей делимого числа и делителя помноженного " +
                "на результат целого целого числа, получаемого при деление делимого на делитель. Иначе говоря остаток от деления - это хвост результата при делении с остатком");
        /*6. Ответить на вопросы:
        Какой тип у doubleResult01 и почему?
        Чему равно значение doubleResult01 и почему?
        int num01 = 3; int num02 = 2; int result = num01 / num02; var doubleResult01 = (double) (num01 / num02);

        ОТВЕТ: doubleResult01 будет иметь тип double. В примере выше используется явное приведение типов (значение переменной типа int приводится к типу double)
         т.к. результат вычисления всегда повышается до наибольшего операнда, то и результат doubleResult01 будет иметь тип double, doubleResult01=1.0
         т.к. приведение типов реализуется для вычесленного выражения, а не для переменной. В процессе вычисления происходит потеря данных
         */

    }
}

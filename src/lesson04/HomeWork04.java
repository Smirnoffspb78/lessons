package lesson04;
/**Пользователь загадывает число в диапазоне от [1 до 100]. Число является целым
Пользователь загадывает в уме, программа не хранит это число, а пытается его угадать.
Программа пытается его угадать (вместо обычного перебора постарайтесь
        использовать метод бинарного поиска, т.е деление отрезка на 2, пока число не будет найдено).
Программа может задавать пользователю вопросы: Число равно ...?, 0 и, в зависимости от ответа пользователя, принимать решения.
Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
Для вывода текста и значения переменной используйте оператор сложения, например System.out.println("Число равно " + number);
 */
public class HomeWork04 {
public static void main(String[] args) {
    System.out.println("Загаданное число " + BinarySearch.binarySearchInt());
    }
}
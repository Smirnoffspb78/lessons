package lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.logging.Logger;


/**
 * Класс, реализующий методы сортировки массива на уникальные и не уникальные элементы.
 * Порядок уникальных элементов остается неизменным, но переносится в начало массива.
 * Порядок не уникальных элементов также остается неизменным, но переносится в конец массива
 * Реализована два вариант:
 * №1 - уникальный элемент - элемент, который встречается в массиве только один раз
 * №2 - уникальный элемент - элемент, который встречается в массиве в первый раз
 */
public class SortingUniqueItems {
    private SortingUniqueItems() {
    }

    private static final int[] errorArray = {0}; //Возвращаемый массив, в случае некорректно переданных данных

    private static final Logger LOGGER = Logger.getLogger(SortingUniqueItems.class.getName()); //Объект для вывода информации в консоль

    /**
     * Вспомогательный метод для проверки передаваемых массивов
     */
    private static boolean checkError(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод " + Thread.currentThread().getStackTrace()[2].getMethodName() + " передан null ");
            return false;
        } else if (arr.length < 1) {
            LOGGER.warning("В метод " + Thread.currentThread().getStackTrace()[2].getMethodName() + " передан массив длииной меньше 1");
            return false;
        }
        return true;
    }

    /**
     * Метод для поиска неуникальных элементов и сортировки использует вложенные циклы
     * Реализация задачи №1
     */
    public static int[] sortingUniqueItems(int[] arr) {
        boolean check = checkError(arr);
        if (!check) {
            return errorArray;
        }

        int temp;
        int[] arraySorted = arr.clone();
        var counter = 1;
        boolean checkShift;
        int i = 0;
        while (i < arraySorted.length - counter) {
            checkShift = false;
            for (int j = 0; j < arraySorted.length; j++) {
                if (j != i && (arraySorted[j] == arraySorted[i])) {
                    temp = arraySorted[j];
                    checkShift = true;
                    for (int k = i; k < arraySorted.length - 1; k++) {
                        arraySorted[k] = arraySorted[k + 1];
                    }
                    arraySorted[arraySorted.length - 1] = temp;
                    counter++;
                }
            }
            if (!checkShift) {
                i++;
            }
        }
        LOGGER.info("Отсортированный массив %s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }

    /**
     * Для поиска и сортировки элементов используются коллекции
     * Реализация задачи №1
     */
    public static int[] sortingUniqueItemsWithCollectionOnly(int[] arr) {
        boolean checkArr = checkError(arr);
        if (!checkArr) {
            return errorArray;
        }
        int[] arraySorted = arr.clone();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j : arraySorted) {
            arrayList.add(j);
        }
        int i = 0;
        int temp;
        boolean check;
        int count = 0;
        while (i < arrayList.size() - count) {
            check = true;
            temp = arrayList.get(i);
            arrayList.remove(i);
            if (arrayList.contains(temp)) {
                arrayList.add(temp);
                count++;
                check = false;
            } else {
                arrayList.add(i, temp);
            }
            if (check) {
                i++;
            }
        }
        for (int j = 0; j < arraySorted.length; j++) {
            arraySorted[j] = arrayList.get(j);
        }
        LOGGER.info("Отсортированный массив %s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }

    /**
     * Метод ставит в начало массива уникальные элементы, а повторяющиеся переносит в конец.
     * Этап 1 создаем дополнительный массив. Этап 2 - ищем повторяющиеся элементы в обратном порядке следования
     * Реализация задачи №2
     */

    public static int[] uniqueSorting(int[] arr) {
        boolean checkArr = checkError(arr);
        if (!checkArr) {
            return errorArray;
        }
        int[] arraySorted = arr.clone();
        int count = 1;
        int countDuplicate;
        int[] duplicateArray = arr.clone();
        Arrays.sort(duplicateArray);
        int minElement = duplicateArray[0] - 1;
        Arrays.fill(duplicateArray, minElement);
        for (int i = 0; i < arraySorted.length - count; i++) {
            countDuplicate = count - 1;
            for (int j = arraySorted.length - count - 1; j > i; j--) {
                if (arraySorted[j] == arraySorted[i]) {
                    duplicateArray[j + countDuplicate] = arraySorted[j];
                    for (int k = j; k < arraySorted.length - count; k++) {
                        arraySorted[k] = arraySorted[k + 1];
                    }
                    arraySorted[arraySorted.length - count] = minElement;
                    count++;
                }
            }
        }
        for (int j : duplicateArray) {
            if (j != minElement) {
                arraySorted[count] = j;
                count++;
            }
        }
        LOGGER.info("Отсортированный массив методом uniqueSorting%s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }

    /**
     * Метод ставит в начало массива уникальные элементы, а повторяющиеся переносит в конец.
     * На каждом этапе сравниваем текущий элемент с предыдущими
     * Реализация задачи №2
     */
    public static int[] uniqueSorting2(int[] arr) {
        boolean checkArr = checkError(arr);
        if (!checkArr) {
            return errorArray;
        }
        int[] arraySorted = arr.clone();
        int count = 1;
        int i = 1;
        boolean check;
        int temp;
        while (i < arraySorted.length - count) {
            check = false;
            for (int j = i; j > -1; j--) {
                if (arraySorted[j] == arraySorted[i]) {
                    temp = arraySorted[j];
                    check = true;
                    for (int k = i; k < arraySorted.length - 1; k++) {
                        arraySorted[k] = arraySorted[k + 1];
                    }
                    arraySorted[arraySorted.length - 1] = temp;
                    count++;
                }
            }
            if (check) {
                i++;
            }
        }
        LOGGER.info("Отсортированный массив методом uniqueSorting2%s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }

    /**
     * Для сортировки массива используются коллекции
     * Реализация задачи №2
     */
    public static int[] uniqueSortingWithCollection(int[] arr) {
        boolean checkArr = checkError(arr);
        if (!checkArr) {
            return errorArray;
        }
        int[] arraySorted = arr.clone();
        var arrayList = new ArrayList<Integer>();

        for (int j : arraySorted) {
            arrayList.add(j);
        }
        var arraySet = new LinkedHashSet<>(arrayList);
        Iterator<Integer> iterator = arraySet.iterator();
        int temp;
        int i = 0;
        boolean check;
        while (iterator.hasNext()) {
            temp = iterator.next();
            check = true;
            while (i < arrayList.size() && check) {
                if (temp == arrayList.get(i)) {
                    arrayList.remove(arrayList.get(i));
                    check = false;
                }
                i++;
            }
        }
        arrayList.addAll(0, arraySet);
        for (int k = 0; k < arraySorted.length; k++) {
            arraySorted[k] = arrayList.get(k);
        }
        LOGGER.info("Отсортированный массив методом uniqueSortingWithCollection%s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }
}

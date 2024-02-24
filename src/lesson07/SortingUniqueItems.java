package lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.logging.Logger;

/**
 * Класс, реализующий методы сортировки массива на уникальные и не уникальные элементы.
 * <p>Порядок уникальных элементов остается неизменным, но переносится в начало массива.
 * Порядок не уникальных элементов также остается неизменным, но переносится в конец массива.
 * Реализована два вариант:
 * <p>- №1 - уникальный элемент - элемент, который встречается в массиве только один раз;
 * <p>- №2 - уникальный элемент - элемент, который встречается в массиве в первый раз.
 */
public class SortingUniqueItems {
    private SortingUniqueItems() {
    }

    private static final int[] ERROR_ARRAY = {};
    private static final Logger LOGGER = Logger.getLogger(SortingUniqueItems.class.getName());

    private static boolean checkError(int[] arr, String nameMethod) {
        if (arr == null) {
            LOGGER.warning("В метод %s передан null ".formatted(nameMethod));
            return false;
        } else if (arr.length < 1) {
            LOGGER.warning("В метод %s передан массив длииной меньше 1".formatted(nameMethod));
            return false;
        }
        return true;
    }

    /**
     * Метод для поиска неуникальных элементов и сортировки использует вложенные циклы.
     * <P>Реализация задачи №1.
     *
     * @param arr Исходный неотсортированный массив.
     * @return Отсортированный массив или пустой массив в случае неверных исходных данных.
     */
    public static int[] sortingUniqueItems(int[] arr) {
        String nameMethod = "sortingUniqueItems";
        boolean check = checkError(arr, nameMethod);
        if (!check) {
            return ERROR_ARRAY;
        }
        int temp;
        int[] arraySorted = arr.clone();
        var counter = 0;
        boolean checkShift;
        int j;
        for (int i = 0; i < arraySorted.length - counter; ) {
            checkShift = false;
            j = 0;
            while (j < arraySorted.length && !checkShift) {
                if (j != i && (arraySorted[j] == arraySorted[i])) {
                    temp = arraySorted[j];
                    checkShift = true;
                    for (int k = i; k < arraySorted.length - 1; k++) {
                        arraySorted[k] = arraySorted[k + 1];
                    }
                    arraySorted[arraySorted.length - 1] = temp;
                    counter++;
                }
                j++;
            }
            if (!checkShift) {
                i++;
            }
        }
        LOGGER.info("Отсортированный массив %s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }

    /**
     * Метод ставит в начало массива уникальные элементы, а повторяющиеся переносит в конец.
     * На каждом этапе сравниваем текущий элемент с предыдущими.
     * <p>Реализация задачи №2.
     *
     * @param arr Исходный неотсортированный массив.
     * @return Отсортированный массив или пустой массив в случае неверных исходных данных..
     */
    public static int[] uniqueSortingWithThreeCycles(int[] arr) {
        String nameMethod = "uniqueSortingWithThreeCycles";
        boolean checkArr = checkError(arr, nameMethod);
        if (!checkArr) {
            return ERROR_ARRAY;
        }
        int[] arraySorted = arr.clone();
        int count = 0;
        int j;
        boolean check;
        int temp;
        for (int i = 1; i < arraySorted.length - count; ) {
            check = false;
            temp = arraySorted[i];
            j = i - 1;
            while (j > -1 && !check) {
                if (arraySorted[j] == arraySorted[i]) {
                    check = true;
                    for (int k = i; k < arraySorted.length - 1; k++) {
                        arraySorted[k] = arraySorted[k + 1];
                    }
                    arraySorted[arraySorted.length - 1] = temp;
                    count++;
                }
                j--;
            }
            if (!check) {
                i++;
            }
        }
        LOGGER.info("Отсортированный массив методом uniqueSorting2 %s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }


    /**
     * Для сортировки используются два массива:
     * массив исходных данных и новый массив, который кладутся отсортированные значения.
     * <p>Реализация задачи №2.
     *
     * @param arr Исходный неотсортированный массив.
     * @return Отсортированный массив или пустой массив в случае неверных исходных данных.
     */
    public static int[] uniqueSortingWithTwoArray(int[] arr) {
        String nameMethod = "uniqueSortingWithTwoArray";
        boolean checkArr = checkError(arr, nameMethod);
        if (!checkArr) {
            return ERROR_ARRAY;
        }
        int[] arrayUnique = new int[arr.length];
        int countUnique = 1;
        boolean checkUnique;
        arrayUnique[0] = arr[0];
        int j;
        for (int i = 1; i < arr.length; i++) {
            checkUnique = true;
            j = i - 1;
            while (j > -1 && checkUnique) {
                checkUnique = (arr[i] != arr[j]);
                j--;
            }
            if (checkUnique) {
                arrayUnique[countUnique] = arr[i];
                countUnique++;
            }
        }
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arrayUnique[k]) {
                arrayUnique[countUnique] = arr[i];
                k--;
                countUnique++;
            }
            k++;
        }
        LOGGER.info("Отсортированный массив методом uniqueSortingWithTwoArray %s".formatted(Arrays.toString(arrayUnique)));
        return arrayUnique;
    }

    /**
     * Для сортировки используются дополнительный массив, хранящий уникальные индексы.
     * <p>Реализация задачи №2.
     *
     * @param arr Исходный неотсортированный массив.
     * @return Отсортированный массив или пустой массив в случае неверных исходных данных..
     */
    public static int[] uniqueSortingWithIndex(int[] arr) {
        String nameMethod = "uniqueSortingWithIndex";
        boolean checkArr = checkError(arr, nameMethod);
        if (!checkArr) {
            return ERROR_ARRAY;
        }
        int[] arrayIndexUnique = new int[arr.length];
        int[] arrayUnique = new int[arr.length];
        int countUnique = 1;
        boolean checkUnique;
        int j;
        for (int i = 1; i < arr.length; i++) {
            checkUnique = true;
            j = i - 1;
            while (j > -1 && checkUnique) {
                checkUnique = (arr[i] != arr[j]);
                j--;
            }
            if (checkUnique) {
                arrayIndexUnique[countUnique] = i;
                countUnique++;
            }
        }
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arrayIndexUnique[k] - i == 0) {
                arrayUnique[k] = arr[i];
                k++;
            } else {
                arrayUnique[countUnique] = arr[i];
                countUnique++;
            }
        }
        LOGGER.info("Отсортированный массив методом uniqueSortingWithIndex %s".formatted(Arrays.toString(arrayUnique)));
        return arrayUnique;
    }

    /**
     * Для сортировки массива используются коллекции.
     * <p>Реализация задачи №2.
     *
     * @param arr Исходный неостортирвоанный массив.
     * @return Отсортированный массив или пустой массив в случае неверных исходных данных.
     */
    public static int[] uniqueSortingWithCollection(int[] arr) {
        String nameMethod = "uniqueSortingWithCollection";
        boolean checkArr = checkError(arr, nameMethod);
        if (!checkArr) {
            return ERROR_ARRAY;
        }
        int[] arraySorted = new int[arr.length];
        var arrayList = new ArrayList<Integer>();
        var arrayListNonUnique = new ArrayList<Integer>();
        for (int j : arr) {
            arrayList.add(j);
        }
        var arraySet = new LinkedHashSet<Integer>();
        int countArr = 0;
        for (int j : arrayList) {
            if (arraySet.contains(j)) {
                arrayListNonUnique.add(j);
            } else {
                arraySet.add(j);
                arraySorted[countArr] = j;
                countArr++;
            }
        }
        for (int j : arrayListNonUnique) {
            arraySorted[countArr] = j;
            countArr++;
        }
        LOGGER.info("Отсортированный массив методом uniqueSortingWithCollection %s".formatted(Arrays.toString(arraySorted)));
        return arraySorted;
    }
}

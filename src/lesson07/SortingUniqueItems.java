package lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Класс, реализующий методы сортировки массива на уникальные и не уникальные элементы.
 * Порядок уникальных элементов остается неизменным, но переносится в начало массива.
 * Порядок не уникальных элементов также остается неизменным, но переносится в конец массива
 */
public class SortingUniqueItems {
    private SortingUniqueItems() {
    }

    private static final Logger LOGGER = Logger.getLogger(SortingUniqueItems.class.getName());

    public static int[] sortingUniqueItems(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод sortingUniqueItems передан null");
            return new int[1];
        } else if (arr.length < 1) {
            LOGGER.warning("В метод sortingUniqueItems передан массив длииной меньше 1");
            return new int[1];
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
        LOGGER.info("Отсортированный массив " + Arrays.toString(arraySorted));
        return arraySorted;
    }

    /**
     * Метод для поиска неуникальных элементов использует коллекции, а для сортировки обычную перестановку
     */
    public static int[] sortingUniqueItemsWithCollection(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод SortingUniqueItemsWithCollection передан null");
            return new int[1];
        } else if (arr.length < 1) {
            LOGGER.warning("В метод SortingUniqueItemsWithCollection передан массив длииной меньше 1");
            return new int[1];
        }
        int[] arraySorted = arr.clone();
        HashSet<Integer> arraySet = new HashSet<>();
        HashSet<Integer> nonUniqueElements = new HashSet<>();
        for (int j : arraySorted) {
            if (arraySet.contains(j)) {
                nonUniqueElements.add(j);
            }
            arraySet.add(j);
        }
        int count = 1;
        int temp;
        boolean check;
        int i = 0;
        while (i < arraySorted.length - count) {
            check = false;
            if (nonUniqueElements.contains(arraySorted[i])) {
                check = true;
                temp = arraySorted[i];
                for (int j = i; j < arraySorted.length - 1; j++) {
                    arraySorted[j] = arraySorted[j + 1];
                }
                arraySorted[arraySorted.length - 1] = temp;
                count++;
            }
            if (!check) {
                i++;
            }
        }
        LOGGER.info("Отсортированный массив " + Arrays.toString(arraySorted));
        return arraySorted;
    }

    public static int[] sortingUniqueItemsWithCollectionOnly(int[] arr) {
        if (arr == null) {
            LOGGER.warning("В метод SortingUniqueItemsWithCollection передан null");
            return new int[1];
        } else if (arr.length < 1) {
            LOGGER.warning("В метод SortingUniqueItemsWithCollection передан массив длииной меньше 1");
            return new int[1];
        }
        int[] arraySorted = arr.clone();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> nonUniqueElements = new ArrayList<>();
        for (int j : arraySorted) {
            if (arrayList.contains(j) && nonUniqueElements.contains(j)) {
                nonUniqueElements.add(j);
                arrayList.add(j);
            } else if (arrayList.contains(j)) {
                nonUniqueElements.add(j);
                nonUniqueElements.add(j);
                arrayList.add(j);
            } else {
                arrayList.add(j);
            }
        }
        arrayList.removeAll(nonUniqueElements);
        arrayList.addAll(nonUniqueElements);
        for (int j = 0; j < arraySorted.length; j++) {
            arraySorted[j] = arrayList.get(j);
        }
        LOGGER.info("Отсортированный массив " + Arrays.toString(arraySorted));
        return arraySorted;
    }
}

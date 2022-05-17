package homework;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 3, 9, 4, 1, 7, 22};
        System.out.println("Before: " + Arrays.toString(array));
        mergeSort(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        if (array.length == 1)
            return;
        int[] arrayOne = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] arrayTwo = Arrays.copyOfRange(array, arrayOne.length, array.length);
        mergeSort(arrayOne);
        mergeSort(arrayTwo);
        merge(array, arrayOne, arrayTwo);
    }

    private static void merge(int[] sortedArray, int[] arrayOne, int[] arrayTwo) {
        int a = 0; int b = 0; int c = 0;
        while (a < arrayOne.length && b < arrayTwo.length) {
            if (arrayOne[a] <= arrayTwo[b]) {
                sortedArray[c] = arrayOne[a];
                a++;
            } else {
                sortedArray[c] = arrayTwo[b];
                b++;
            }
            c++;
        }
        while (a < arrayOne.length) {
            sortedArray[c] = arrayOne[a];
            a++;
            c++;
        }
        while (b < arrayTwo.length) {
            sortedArray[c] = arrayTwo[b];
            b++;
            c++;
        }
    }

}

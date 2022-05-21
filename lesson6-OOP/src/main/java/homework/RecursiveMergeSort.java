package homework;

import java.util.ArrayList;
import java.util.List;

public class RecursiveMergeSort {

    /**
     * Implement a generic method that accepts and sorts a List of Comparable elements using a recursive Merge Sort algorithm.
     * (Please note that it should sort a provided list, not create a new one).
     */

    public static void main(String[] args) {
        var elements = new ArrayList<Integer>();
        elements.add(199);
        elements.add(11);
        elements.add(555);
        elements.add(2);
        elements.add(1);
        System.out.println("Original list: " + elements);
        recursiveMergeSort(elements);
        System.out.println("Sorted list:" + elements);
    }

    private static <T extends Comparable<T>> void recursiveMergeSort(List<T> elements) {
        if(elements.size() == 1)
            return;
        List<T> left = new ArrayList<>(elements.subList(0, elements.size()/2));
        List<T> right = new ArrayList<>(elements.subList(left.size(), elements.size()));
        recursiveMergeSort(left);
        recursiveMergeSort(right);
        merge(elements, left, right);
    }

    private static <T extends Comparable<T>> void merge(List<T> elements, List<T> left, List<T> right) {
        int a = 0; int b = 0; int c = 0;
        while (a < left.size() && b < right.size()) {
            if (left.get(a).compareTo(right.get(b)) > 0) {
                elements.set(c, right.get(b));
                b++;
            } else {
                elements.set(c, left.get(a));
                a++;
            }
            c++;
        }
        while (a < left.size()){
            elements.set(c, left.get(a));
            a++;
            c++;
        }
        while (b < right.size()){
            elements.set(c, right.get(b));
            b++;
            c++;
        }
    }

}
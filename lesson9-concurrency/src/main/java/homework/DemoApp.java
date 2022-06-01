package homework;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class DemoApp {

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 0, 99, 33, 55, 120};
        System.out.println("Before: " + Arrays.toString(arr));
        ForkJoinPool.commonPool().invoke(new MergeSortTask(arr));
        System.out.println("After: " + Arrays.toString(arr));
    }

}

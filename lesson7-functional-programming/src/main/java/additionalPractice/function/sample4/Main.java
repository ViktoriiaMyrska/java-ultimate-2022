package additionalPractice.function.sample4;

import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String[]> fun1 = a -> a.split(" ");
        Function<String[], int[]> fun2 = Main::getLength;
        Function<String, int[]> fun3 = fun1.andThen(fun2);
        int[] result = fun3.apply("Java the best!");
        System.out.println(Arrays.toString(result));

    }

    public static int[] getLength(String[] arr){
        int[] result = new int[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[i].length();
        }
        return result;
    }

}

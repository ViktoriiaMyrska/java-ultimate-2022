package additionalPractice.function.sample7;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        BiFunction<String, String, String[]> fun1 = (a, b) -> a.split(b);
        Function<String[], String> fun2 = a -> String.join("", a);
        BiFunction<String, String, String> fun3 = fun1.andThen(fun2);

        String text = "Java   the     best";
        String reg = "{1,}\s";

        String result = fun3.apply(text, reg);
        System.out.println(result);
    }

}

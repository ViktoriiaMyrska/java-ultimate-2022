package additionalPractice.function.sample8;

import java.util.Date;
import java.util.function.LongFunction;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        LongFunction<Date> fun1 = a -> new Date(a);
        System.out.println(fun1.apply(4_00_000_00L));

        ToIntFunction<String> fun = a -> a.hashCode();
        System.out.println(fun.applyAsInt("java"));
    }

}

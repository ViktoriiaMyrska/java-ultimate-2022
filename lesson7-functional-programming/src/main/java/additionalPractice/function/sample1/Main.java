package additionalPractice.function.sample1;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<String, Integer> fun = new StrToLength();
        System.out.println(fun.apply("Hello!"));

        Function<String, Integer> fun1 = a -> a.length();
        System.out.println(fun1.apply("Simba"));

        Function<String, Integer> fun2 = String::length;
        System.out.println(fun2.apply("Fima"));
    }

}

class StrToLength implements Function<String, Integer>{

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

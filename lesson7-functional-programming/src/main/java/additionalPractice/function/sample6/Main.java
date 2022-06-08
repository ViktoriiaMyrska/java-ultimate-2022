package additionalPractice.function.sample6;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        BiFunction<String, Character, Integer> countLetter = Main::count;
        System.out.println(countLetter.apply("Hello", 'l'));
    }

    public static Integer count(String letter, Character l){
        int result = 0;
        char[] ls = letter.toCharArray();
        for (char c : ls) {
            if (c == l) {
                result++;
            }
        }
        return result;
    }

}

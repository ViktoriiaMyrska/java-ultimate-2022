package additionalPractice.predicate;

import java.util.*;
import java.util.function.IntPredicate;

public class DemoApp {

    public static void main(String[] args) {
//        1) +
        System.out.println("Example 1:");
        List<String> catNames = new ArrayList<>(List.of("Simba", "Fima", "Milka", "Tom", "Fenix"));
        System.out.println("Before: " + catNames);
        catNames.removeIf(a -> a.startsWith("F"));
        System.out.println("After: " + catNames);
        System.out.println("---------");

//        2) +
        System.out.println("Example 2:");
        char[] firstLetters = new char[]{'M', 'i', 'l'};
        catNames.removeIf(a -> Arrays.equals(Arrays.copyOfRange(a.toCharArray(), 0, 3), firstLetters));
        System.out.println("After: " + catNames);
        System.out.println("---------");

//        3) +/-
        System.out.println("Example 3:");
        List<Cat> cats = new ArrayList<>(List.of(new Cat("Simba", 13), new Cat("Milka", 5), new Cat("Fima", 7)));
        System.out.println("Before: " + cats);
        cats.removeIf(DemoApp::catsCriterion);
        System.out.println("After: " + cats);
        System.out.println("---------");

//        4) +
        System.out.println("Example 4:");
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "Hi");
        stringMap.put(2, "Hi");
        stringMap.put(3, "Hello");
        stringMap.put(4, "Hello");
        stringMap.put(5, "Simba");
        System.out.println("Before: " + stringMap);
        stringMap.entrySet().removeIf(integerStringEntry -> integerStringEntry.getKey() != integerStringEntry.getValue().length());
        System.out.println("Sfter: " + stringMap);
        System.out.println("---------");

//        5) +
        System.out.println("Example 5:");
        IntPredicate digitsSum = (a) -> Integer.toString(a).chars().sum() % 2 == 0;
        boolean test = digitsSum.test(100);
        System.out.println(test);
        System.out.println("---------");

    }

    private static boolean catsCriterion(Cat cat) {
        return cat.getAge() < 6 && cat.getName().startsWith("M");
    }

}
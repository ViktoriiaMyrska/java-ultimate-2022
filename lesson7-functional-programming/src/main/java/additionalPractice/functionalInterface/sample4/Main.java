package additionalPractice.functionalInterface.sample4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Hello", "Cat", "Java", "Bag"));
        System.out.println(list);
        list.removeIf(t -> t.length() > 3);
        System.out.println(list);
    }
}

package additionalPractice.functionalInterface.sample9b;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] names = new String[]{"Anna", "Ira", "Alexander", "Katia"};
        Arrays.sort(names, Main::compareStringLength);
        System.out.println(Arrays.toString(names));
    }

    public static int compareStringLength(String a, String b){
        return a.length() - b.length();
    }

}

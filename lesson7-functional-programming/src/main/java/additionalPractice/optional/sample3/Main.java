package additionalPractice.optional.sample3;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String[] names = new String[]{null, null, "Vaska", null, "Barsik"};
        Optional<String> result = Optional.ofNullable(names[0]);
        for(String n: names){
            Optional<String> temp = Optional.ofNullable(n).filter(a -> a.startsWith("B"));
            result = result.or(() -> temp);
        }
        System.out.println(result.get());
    }

}

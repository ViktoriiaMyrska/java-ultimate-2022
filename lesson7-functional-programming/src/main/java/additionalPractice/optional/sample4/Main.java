package additionalPractice.optional.sample4;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String[] names = new String[]{null, null, "Vaska", null, "Barsik"};
        Optional<String> result = Optional.ofNullable(names[0]);
        for(String n: names){
            Optional<String> temp = Optional.ofNullable(n).flatMap(a -> Optional.of(a.toUpperCase()));
            result = result.or(() -> temp);
        }
        System.out.println(result.get());
    }

}

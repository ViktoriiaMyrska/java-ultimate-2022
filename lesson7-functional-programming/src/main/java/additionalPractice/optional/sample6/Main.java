package additionalPractice.optional.sample6;

import additionalPractice.optional.sample1.Cat;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", "Black");
        Cat cat2 = new Cat("Umka", "White");
        Cat cat3 = new Cat("Barsik", "Ginger");
        Cat[] cats = new Cat[]{cat1, cat2, cat3};
        Optional<Cat> result = findCatByNameOptional("Vaskaq", cats);
        result.ifPresent(System.out::println);
        result.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
    }

    private static Optional<Cat> findCatByNameOptional(String name, Cat[] cats) {
        Cat result = null;
        for (Cat cat : cats){
            if (cat.getName().equals(name)){
                result = cat;
                break;
            }
        }
        return Optional.ofNullable(result);
    }
}
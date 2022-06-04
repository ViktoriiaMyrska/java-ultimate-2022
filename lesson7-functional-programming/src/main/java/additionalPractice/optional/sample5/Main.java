package additionalPractice.optional.sample5;

import additionalPractice.optional.sample1.Cat;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", "Black");
        Optional<Cat> result = Optional.of(cat1);
        Optional<Cat> repCat1 = result.map(Main::repaintCat);
        Optional<Cat> repCat2 = result.flatMap(Main::repaintCatOptional);
        System.out.println(repCat1.get());
        System.out.println(repCat2.get());
    }

    private static Optional<Cat> repaintCatOptional(Cat cat) {
        return Optional.of(new Cat(cat.getName(), "Ginger"));
    }

    private static Cat repaintCat(Cat cat) {
        return new Cat(cat.getName(), "White");
    }

}

package additionalPractice.optional.sample1;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Vaska", "Black");
        Cat cat2 = new Cat("Barsik", "White");
        Cat cat3 = new Cat("Umka", "Grey");

        Cat[] cats = new Cat[] {cat1, cat2, cat3};

        Optional<Cat> result = findCatByNameOptional("Vaska", cats);

//        if(result.isPresent()){
//            Cat cat = result.get();
//            System.out.println(cat);
//        } else {
//            System.out.println("Cat not found");
//        }  // использовать вместо этого блока подходы описанные ниже

        Cat defaultCat = new Cat("DefaultName", "DefaultColor");
        Cat cat = result.orElse(defaultCat);
        System.out.println(cat);

        Cat getCat = result.orElseGet(Cat::new);
        System.out.println(getCat);

        Cat catEx = result.orElseThrow();

        String catColor = result.map(a -> a.getColor()).get();
        System.out.println(catColor);

    }

    private static Cat findCatByName(String name, Cat[] cats){
        for (Cat cat: cats){
            if (cat.getName().equals(name)){
                return cat;
            }
        }
        return null;
    }

    private static Cat findCatByNameEx(String name, Cat[] cats) throws NoSuchElementException{
       for (Cat cat: cats){
           if(cat.getName().equals(name)){
               return cat;
           }
       }
       throw new NoSuchElementException();
    }

    private static Optional<Cat> findCatByNameOptional(String name, Cat[] cats) {
        Cat result = null;
        for(Cat cat: cats){
            if(cat.getName().equals(name)){
                result = cat;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

}

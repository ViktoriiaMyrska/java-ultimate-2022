package additionalPractice.functionalInterface.sample2;

import java.util.NoSuchElementException;

@FunctionalInterface
public interface Generator <T>{
    T getNext();

    default void stopGeneration(){
        throw new NoSuchElementException();
    }
}

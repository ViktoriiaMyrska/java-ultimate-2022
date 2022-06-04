package additionalPractice.functionalInterface.sample3;

import java.util.NoSuchElementException;

@FunctionalInterface // позволяет выявить ошибки на этапе компиляции (обязательно указывать для функуиональных интерфейсов)
public interface Generator <T>{
    T getNext(); // единственный абстрактный метод

    default void stopGeneration(){
        throw new NoSuchElementException();
    }

    boolean equals(Object obj); // сигнатура и название метода совпадает с методом из Object
}

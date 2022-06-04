package additionalPractice.functionalInterface.sample6;

public class IntGenerator {
    int next(){ // во всех нестатических методах класса первый параметр - это ссылка на текущий объект this
        // (неявный первый агрумент метода, подставляемый компилятором) Это нужно для того чтобы связать методы и объекты из Metaspace & Heap
        return 42;
    }
}

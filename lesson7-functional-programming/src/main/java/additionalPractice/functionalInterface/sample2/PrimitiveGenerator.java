package additionalPractice.functionalInterface.sample2;

@FunctionalInterface
public interface PrimitiveGenerator {
    int getNextInt();
    default double getNextDouble(){
        return 0;
    };
}

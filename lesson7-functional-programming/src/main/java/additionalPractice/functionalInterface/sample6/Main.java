package additionalPractice.functionalInterface.sample6;

public class Main {

    public static void main(String[] args) {
        Generator gen1 = IntGenerator::next;
        IntGenerator a = new IntGenerator();
        System.out.println(gen1.getNextElement(a));
    }

}

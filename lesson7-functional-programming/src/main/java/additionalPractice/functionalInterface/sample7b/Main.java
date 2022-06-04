package additionalPractice.functionalInterface.sample7b;

public class Main {

    public static void main(String[] args) {
        Generator gen = int[]::new;
        Object a = gen.createNewObject(17);
        System.out.println(a.getClass());
    }
}

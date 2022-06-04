package additionalPractice.functionalInterface.sample5;

public class Main {

    public static void main(String[] args) {
        SimpleGen sg = new SimpleGen(20);
        Generator gen1 = sg::getNumber;
        int temp = gen1.getNextElement();
        int temp2 = gen1.getNextElement();
        System.out.println(temp);
        System.out.println(temp2);
        Generator gen2 = SimpleGen::getRandomNumber;
        int temp3 = gen2.getNextElement();
        System.out.println(temp3);
    }
}

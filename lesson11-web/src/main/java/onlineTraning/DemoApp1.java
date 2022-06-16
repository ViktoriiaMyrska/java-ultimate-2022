package onlineTraning;

import java.util.stream.IntStream;

public class DemoApp1 {

    /*
    Using one Stream API statement find a sum of all prime numbers from 501st to 520th inclusively.
A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
Please note that 501 and 520 is a position in the list of prime numbers, not a value:exclamation:️ E.g. take a look at the first five prime numbers:
     */

    public static void main(String[] args) {
        System.out.println(findSum());
    }

    private static int findSum() {
//        IntStream.rangeClosed(1, 520)
//                .filter(DemoApp1::isPrime)
//                .sum();
        return 1;
    }


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

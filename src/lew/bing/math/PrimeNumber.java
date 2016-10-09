package lew.bing.math;

/**
 * Created by Y on 2016/8/21.
 */
public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(100000001));
    }

    public static boolean isPrime(long num) {
        for (long i = 2;i < num ;i++) {
            if (num % i == 0L) {
                System.out.println(i);
                return false;
            }
            if (i * i  > num) {
                return true;
            }
        }
        return true;
    }

}

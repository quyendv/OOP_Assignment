package Week3.Fibonacci;

public class Fibonacci {
    /**
     * Tra ve so fibonacci thu n.
     *
     * @param n : index
     * @return fib[n]
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - a < b) {
                return Long.MAX_VALUE;
            }
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

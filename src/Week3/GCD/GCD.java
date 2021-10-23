package Week3.GCD;

public class GCD {
    /**
     * implement gcd method.
     * @param a num1
     * @param b num2
     * @return  gcd a, b
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Math.abs(gcd(b, a % b));
    }
}
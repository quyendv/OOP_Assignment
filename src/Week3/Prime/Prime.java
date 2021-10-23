package Week3.Prime;

public class Prime {
    /**
     * Implement check is Prime.
     * @param n number
     * @return result
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

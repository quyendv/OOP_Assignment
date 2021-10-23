package Week3.Fraction;

public class Fraction {
    private int numerator;
    private int denominator = 1;

    // getter / setter
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator == 0 ? this.denominator : denominator;
    }

    /**
     * Constructor.
     *
     * @param numerator   num
     * @param denominator den
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator == 0 ? this.denominator : denominator;
    }

    /**
     * find gcd of 2 num.
     *
     * @param a num1
     * @param b num2
     * @return gcd
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Math.abs(gcd(b, a % b));
    }

    /**
     * Reduce fraction.
     *
     * @return curFraction
     */
    public Fraction reduce() {
        int c = gcd(this.numerator, this.denominator);
        numerator /= c;
        denominator /= c;
        return this;
    }

    /**
     * Add 2 fractions.
     *
     * @param other other fraction
     * @return curFraction
     */
    public Fraction add(Fraction other) {
        numerator = numerator * other.denominator + denominator * other.numerator;
        denominator *= other.denominator;
        return this;
    }

    /**
     * Sub 2 fractions.
     *
     * @param other other fraction
     * @return curFraction
     */
    public Fraction subtract(Fraction other) {
        numerator = numerator * other.denominator - denominator * other.numerator;
        denominator *= other.denominator;
        return this;
    }

    /**
     * multiply 2 fractions.
     *
     * @param other other fraction
     * @return curFraction
     */
    public Fraction multiply(Fraction other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        return this;
    }

    /**
     * divide 2 fractions.
     *
     * @param other other fraction
     * @return curFraction
     */
    public Fraction divide(Fraction other) {
        numerator *= other.denominator;
        denominator *= other.numerator;
        return this;
    }

    /**
     * compare curFaction to obj.
     *
     * @param obj otherObj
     * @return isEqual?
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) {
            return false;
        }
        return numerator * ((Fraction) obj).denominator == denominator * ((Fraction) obj).numerator;
    }
}


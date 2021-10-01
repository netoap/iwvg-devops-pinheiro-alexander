package es.upm.miw.iwvg_devops.pratica;

import java.util.Objects;

public class Fraction {
    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public Fraction() {
        this(1, 1);
    }

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
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return Math.abs(this.numerator) < Math.abs(this.denominator);
    }

    public boolean isImproper() {
        return Math.abs(this.numerator) > Math.abs(this.denominator);
    }

    public boolean isEquivalent(Fraction fraction) {
        return this.decimal() == fraction.decimal();
    }

    public Fraction add(Fraction fraction) {
        if (this.denominator == fraction.getDenominator()) {
            return new Fraction(this.numerator + fraction.getNumerator(), this.denominator);
        }
        return new Fraction((this.numerator * fraction.denominator) + (this.denominator * fraction.numerator), this.denominator * fraction.denominator);
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction divide(Fraction fraction) {
        return this.multiply(invert(fraction));
    }

    private Fraction invert(Fraction fraction) {
        return new Fraction(fraction.getDenominator(), fraction.getNumerator());
    }

    private void reduce() {
        int mcd = maximumCommonDivisor();
        if (mcd > 1) {
            this.setNumerator(this.numerator / mcd);
            this.setDenominator(this.denominator / mcd);
        }
    }

    private int maximumCommonDivisor() {
        int tmp;
        int a = this.numerator;
        int b = this.denominator;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return Math.abs(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}

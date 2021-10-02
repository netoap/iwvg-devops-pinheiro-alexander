package es.upm.miw.iwvg_devops.rest.pratica;

import es.upm.miw.iwvg_devops.pratica.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
        assertEquals(fraction, new Fraction(20, 30));
    }

    @Test
    void testFraction() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        fraction = new Fraction(3, 78);
        assertEquals(0.0384, fraction.decimal(), 0.001);
    }

    @Test
    void testIsProper() {
        assertTrue(new Fraction(3, 8).isProper());
    }

    @Test
    void testIsImproper() {
        assertTrue(new Fraction(8, 3).isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction1 = new Fraction();
        fraction1.setNumerator(6);
        fraction1.setDenominator(9);
        assertTrue(fraction.isEquivalent(fraction1));
        assertTrue(new Fraction(23, 13).isEquivalent(new Fraction(230, 130)));
    }

    @Test
    void testAdd() {
        assertEquals(new Fraction(5, 3), fraction.add(new Fraction(3, 3)));
        assertEquals(new Fraction(7, 6), fraction.add(new Fraction(1, 2)));
    }

    @Test
    void testMultiply() {
        assertEquals(new Fraction(2, 9), fraction.multiply(new Fraction(5, 15)));
    }

    @Test
    void testDivide() {
        assertEquals(fraction.divide(new Fraction(1, 5)), new Fraction(10, 3));
    }
}

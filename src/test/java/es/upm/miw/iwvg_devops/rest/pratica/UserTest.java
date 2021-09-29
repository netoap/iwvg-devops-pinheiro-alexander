package es.upm.miw.iwvg_devops.rest.pratica;

import es.upm.miw.iwvg_devops.pratica.Fraction;
import es.upm.miw.iwvg_devops.pratica.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.util.CollectionUtils.*;

public class UserTest {

    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(2, 3));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testUser() {
        assertEquals("1", user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getFamilyName());
        assertEquals(new Fraction(1, 2), user.getFractions().get(0));
        assertEquals(List.of(
                new Fraction(1, 2),
                new Fraction(2, 3)
        ), user.getFractions());
    }

    @Test
    void testAddFraction() {
        List<Fraction> expectedFractions = List.of(
                new Fraction(1, 2),
                new Fraction(2, 3),
                new Fraction(3, 4));
        user.addFraction(new Fraction(3, 4));
        assertEquals(expectedFractions, user.getFractions());
        assertEquals(3, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }
}

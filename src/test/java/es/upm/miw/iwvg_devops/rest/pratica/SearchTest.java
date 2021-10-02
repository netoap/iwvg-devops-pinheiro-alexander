package es.upm.miw.iwvg_devops.rest.pratica;

import es.upm.miw.iwvg_devops.pratica.Fraction;
import es.upm.miw.iwvg_devops.pratica.Search;
import es.upm.miw.iwvg_devops.pratica.User;
import es.upm.miw.iwvg_devops.pratica.UsersDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    private Search search;

    @BeforeEach
    void before() {
        search = new Search();
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertTrue(search.findUserIdBySomeProperFraction().findAny().isPresent());
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        assertTrue(search.findUserFamilyNameInitialBySomeProperFraction().findAny().isPresent());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        assertEquals(new Fraction(0, 1), search.findFractionMultiplicationByUserFamilyName("Fernandez"));
        Search searchAPinheiro = new Search();
        assertNull(searchAPinheiro.findFractionMultiplicationByUserFamilyName("APinheiro"));
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        //assertTrue(search.findUserIdByAllProperFraction().findFirst().isPresent());
        assertEquals("5", search.findUserIdByAllProperFraction().findAny().get());
        Search wrongSearch = new Search();
        assertNotEquals("6", wrongSearch.findUserIdByAllProperFraction().findAny().get());
    }
}

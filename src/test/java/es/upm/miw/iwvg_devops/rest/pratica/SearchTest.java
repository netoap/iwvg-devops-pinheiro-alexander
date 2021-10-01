package es.upm.miw.iwvg_devops.rest.pratica;

import es.upm.miw.iwvg_devops.pratica.Search;
import es.upm.miw.iwvg_devops.pratica.User;
import es.upm.miw.iwvg_devops.pratica.UsersDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SearchTest {
    private Search search;

    @BeforeEach
    void before() {
        search = new Search();
    }

    
}

package es.upm.miw.iwvg_devops.pratica;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Search implements ISearch {
    private Stream<User> users;

    public Search() {
        users = new UsersDatabase().findAll();
    }




}

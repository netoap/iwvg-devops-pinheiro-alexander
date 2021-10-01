package es.upm.miw.iwvg_devops.pratica;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Search implements ISearch {
    private Stream<User> users;

    public Search() {
        users = new UsersDatabase().findAll();
    }


    @Override
    public Stream<String> findUserIdBySomeProperFraction() {
        return users.filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId);
    }

    @Override
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return users.filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(user->user.getFamilyName().substring(0, 1)).distinct();
    }

    @Override
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        // To do
        return null;
    }

    @Override
    public Stream<String> findUserIdByAllProperFraction() {
        //To do
        return null;
    }
}

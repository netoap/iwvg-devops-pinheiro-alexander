package es.upm.miw.iwvg_devops.pratica;

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
                .map(user -> user.getFamilyName().substring(0, 1)).distinct();
    }

    @Override
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return users.filter(user -> user.getFamilyName().equals(familyName)).flatMap(user -> user.getFractions().stream()).reduce(Fraction::multiply).orElse(null);
    }

    @Override
    public Stream<String> findUserIdByAllProperFraction() {
        return users.filter(user -> user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }
}

package es.upm.miw.iwvg_devops.pratica;

import java.util.stream.Stream;

public interface ISearch {
    Stream<String> findUserIdBySomeProperFraction();
    Stream<String> findUserFamilyNameInitialBySomeProperFraction();
    Fraction findFractionMultiplicationByUserFamilyName(String familyName);
    Stream<String> findUserIdByAllProperFraction();
}

package com.countries.nuts.helpers;

import com.countries.nuts.domains.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryHelperMock {

    private CountryHelperMock() {}

    public static List<Country> getAllCountries() {

        Country country1 = new Country("BR", List.of("de", "sw", "en"));
        Country country2 = new Country("CN", List.of("de", "es", "en", "op", "str"));
        Country country3 = new Country("EN", List.of("sw", "fr"));
        Country country4 = new Country("CA", List.of("gr", "en"));
        Country country5 = new Country("PT", List.of("an"));

        return new ArrayList<>(List.of(country1, country2, country3, country4, country5));

    }

}

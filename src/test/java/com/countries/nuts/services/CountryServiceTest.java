package com.countries.nuts.services;

import com.countries.nuts.clients.CountryClient;
import com.countries.nuts.domains.Country;
import com.countries.nuts.domains.LanguageResponse;
import com.countries.nuts.domains.NumberCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.countries.nuts.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryServiceTest {

    @InjectMocks
    private CountryService countryService;

    @Mock
    private CountryClient countryClient;

    @BeforeEach
    public void setUp(){
        when(countryClient.getCountries()).thenReturn(getAllCountries());
    }

    @Test
    public void shouldReturnMostOfficialLanguageOk(){
        Country country = countryService.mostOfficialLanguage();
        assertEquals(country.getCountry(), COUNTRY_BR);
    }

    @Test
    public void shouldReturnMostOfficialLanguageNotEquals(){
        Country country = countryService.mostOfficialLanguage();
        assertNotEquals(country.getCountry(), COUNTRY_PT);
    }

    @Test
    public void shouldReturnHighestNumberOfficialLanguageOk(){
        Country country = countryService.highestNumberOfficialLanguage();
        assertEquals(country.getCountry(), COUNTRY_CN);
    }

    @Test
    public void shouldReturnHighestNumberOfficialLanguageNotEquals(){
        Country country = countryService.highestNumberOfficialLanguage();
        assertNotEquals(country.getCountry(), COUNTRY_CA);
    }

    @Test
    public void shouldReturnOfficialLanguagesOk(){
        LanguageResponse language = countryService.officialLanguages();
        assertEquals(language.getLanguages().size(), 8);
    }

    @Test
    public void shouldReturnOfficialLanguagesFalse(){
        LanguageResponse language = countryService.officialLanguages();
        assertNotEquals(language.getLanguages().size(), 3);
    }

    @Test
    public void shouldReturnMostCommonOfficialLanguageOk(){
        LanguageResponse language = countryService.mostCommonOfficialLanguage();
        assertEquals(language.getLanguages().size(), 4);
    }

    @Test
    public void shouldReturnMostCommonOfficialLanguageNotEmpty(){
        LanguageResponse language = countryService.mostCommonOfficialLanguage();
        assertFalse(language.getLanguages().isEmpty());
    }

    @Test
    public void shouldReturnNumberOfCountries(){
        NumberCountry numberOfCountries = countryService.numberOfCountries();
        assertTrue(numberOfCountries.getNumberOfCountries() > 0);
    }

    @Test
    public void shouldReturnNumberOfCountriesNull(){
        NumberCountry numberOfCountries = null;
        assertNull(numberOfCountries);
    }

    public static List<Country> getAllCountries() {

        Country country1 = new Country(COUNTRY_BR, List.of(LANGUAGE_DE, LANGUAGE_PT, LANGUAGE_ES));
        Country country2 = new Country(COUNTRY_CN, List.of(LANGUAGE_ES, LANGUAGE_SW, LANGUAGE_AN, LANGUAGE_EN));
        Country country3 = new Country(COUNTRY_EN, List.of(LANGUAGE_SW, LANGUAGE_FR));
        Country country4 = new Country(COUNTRY_CA, List.of(LANGUAGE_GR, LANGUAGE_EN));
        Country country5 = new Country(COUNTRY_PT, List.of(LANGUAGE_AN));

        return new ArrayList<>(List.of(country1, country2, country3, country4, country5));

    }
}

package com.countries.nuts.services;

import com.countries.nuts.domains.Country;
import com.countries.nuts.domains.LanguageResponse;
import com.countries.nuts.clients.CountryClient;
import com.countries.nuts.domains.NumberCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryClient countryRepository;

    public NumberCountry numberOfCountries() {

        List<Country> countries = countryRepository.getCountries();
        NumberCountry numberCountry = new NumberCountry(countries.size());
        return numberCountry;
    }

    public Country mostOfficialLanguage(){

        List<Country> countries = countryRepository.getCountries();

        return countries.stream()
                .filter(country1 -> country1.getLanguages().contains("de"))
                .max(Comparator.comparing(c -> c.getLanguages().size())).get();
    }

    public Country highestNumberOfficialLanguage(){

        List<Country> countries = countryRepository.getCountries();

        return countries.stream()
                .max(Comparator.comparing(c -> c.getLanguages().size())).get();
    }

    public LanguageResponse officialLanguages(){

        List<Country> countries = countryRepository.getCountries();

        LanguageResponse languageResponse = new LanguageResponse();
        Set<String> strings = new HashSet<>();

        countries.forEach(country -> strings.addAll(country.getLanguages().stream().toList()));

        languageResponse.setLanguages(strings);

        return languageResponse;
    }

    public LanguageResponse mostCommonOfficialLanguage(){

        List<Country> countries = countryRepository.getCountries();

        LanguageResponse languageResponse = new LanguageResponse();
        List<String> strings = new ArrayList<>();

        countries.forEach(country -> strings.addAll(
                country.getLanguages().stream().toList()));

        Set<String> collect = strings.stream().filter(i -> Collections.frequency(strings, i) > 1)
                .collect(Collectors.toSet());

        languageResponse.setLanguages(collect);

        return languageResponse;
    }



}

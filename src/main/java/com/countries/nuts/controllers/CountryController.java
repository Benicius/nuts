package com.countries.nuts.controllers;

import com.countries.nuts.domains.Country;
import com.countries.nuts.domains.LanguageResponse;
import com.countries.nuts.domains.NumberCountry;
import com.countries.nuts.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/numberOfCountries")
    public ResponseEntity<NumberCountry> numberOfCountries(){
        return new ResponseEntity<>(countryService.numberOfCountries(), HttpStatus.OK);
    }

    @GetMapping("/mostOfficialLanguage")
    public ResponseEntity<Country> mostOfficialLanguage(){
        return new ResponseEntity<>(countryService.mostOfficialLanguage(), HttpStatus.OK);
    }

    @GetMapping("/highestNumberOfficialLanguage")
    public ResponseEntity<Country> highestNumberOfficialLanguage(){
        return new ResponseEntity<>(countryService.highestNumberOfficialLanguage(), HttpStatus.OK);
    }

    @GetMapping("/languages")
    public ResponseEntity<LanguageResponse> officialLanguages(){
        return new ResponseEntity<>(countryService.officialLanguages(), HttpStatus.OK);
    }

    @GetMapping("/mostCommonOfficialLanguage")
    public ResponseEntity<LanguageResponse> mostCommonOfficialLanguage(){
        return new ResponseEntity<>(countryService.mostCommonOfficialLanguage(), HttpStatus.OK);
    }


}

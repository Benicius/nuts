package com.countries.nuts.clients;

import com.countries.nuts.domains.Country;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;

import static com.countries.nuts.helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CountryClientTests {

    private CountryClient countryClient;

    @Test
    public void whenGetGetCountryClientReturnOk(){
        this.builderFeignClient(new MockClient().ok(
                HttpMethod.GET,
                BASE_URL.concat(ENDPOINT),
                RESPONSE_BODY
        ));

        List<Country> countries = countryClient.getCountries();
        assertFalse(countries.isEmpty());
    }

    private void builderFeignClient(MockClient mockClient){
        countryClient = Feign.builder()
                .client(mockClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(CountryClient.class, BASE_URL);
    }
}

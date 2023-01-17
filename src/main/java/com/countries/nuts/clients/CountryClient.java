package com.countries.nuts.clients;

import com.countries.nuts.domains.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="${feign.client.name}", url = "${feign.client.url}")
public interface CountryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/countries")
    List<Country> getCountries();
}

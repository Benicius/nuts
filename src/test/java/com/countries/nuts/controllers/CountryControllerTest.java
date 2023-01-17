package com.countries.nuts.controllers;

import com.countries.nuts.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = CountryController.class)
public class CountryControllerTest {

    @MockBean
    private CountryService countryService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void numberOfCountries_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/countries/numberOfCountries")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void mostOfficialLanguage_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/countries/mostOfficialLanguage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void highestNumberOfficialLanguage_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/countries/highestNumberOfficialLanguage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void languages_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/countries/languages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void mostCommonOfficialLanguage_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/countries/mostCommonOfficialLanguage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

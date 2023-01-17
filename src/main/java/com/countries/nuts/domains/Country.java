package com.countries.nuts.domains;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Country {
    private String country;
    private List<String> languages;
}

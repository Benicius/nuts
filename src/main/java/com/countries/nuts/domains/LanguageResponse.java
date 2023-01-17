package com.countries.nuts.domains;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LanguageResponse {
    Set<String> languages;
}

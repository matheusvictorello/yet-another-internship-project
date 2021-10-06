package com.victorello.yetanotherinternshipproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationResponse {

    @Getter
    @Setter
    private final String jwt;
}

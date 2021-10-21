package com.victorello.yetanotherinternshipproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class SignUpResponse {

    @Getter
    @Setter
    private final String jwt;
}

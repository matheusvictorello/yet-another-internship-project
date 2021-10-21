package com.victorello.yetanotherinternshipproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class SignUpRequest {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;
}

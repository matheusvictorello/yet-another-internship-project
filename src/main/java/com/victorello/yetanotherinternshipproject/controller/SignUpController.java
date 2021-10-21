package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.domain.*;
import com.victorello.yetanotherinternshipproject.mapper.exceptions.InvalidReferenceIdException;
import com.victorello.yetanotherinternshipproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(SignUpController.REST_URL)
public class SignUpController {
    public static final String REST_URL = "/signup";

    private UserService userService;

    @PostMapping("")
    public ResponseEntity<Boolean> getAuthenticationToken(@RequestBody SignUpRequest signUpRequest) throws Exception {
        try {
            User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword());
            userService.save(user);
            return ResponseEntity.ok(true);
        } catch (InvalidReferenceIdException | ConstraintViolationException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}

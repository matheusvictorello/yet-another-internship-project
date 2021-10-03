package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dto.UserDTO;
import com.victorello.yetanotherinternshipproject.mapper.UserDTOMapper;
import com.victorello.yetanotherinternshipproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(AuthController.REST_URL)
public class AuthController {
    public static final String REST_URL = "/api/auth";

    @Autowired
    protected UserService service;

    @Autowired
    protected UserDTOMapper mapper;

    @GetMapping("/{name}")
    public ResponseEntity<UserDTO> getById(@PathVariable("name") String name) {
        Optional<UserDTO> dto = mapper.toDTO(
                service.findByName(name)
        );
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

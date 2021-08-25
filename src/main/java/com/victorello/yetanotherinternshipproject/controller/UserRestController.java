package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.User;
import com.victorello.yetanotherinternshipproject.dto.UserDTO;
import com.victorello.yetanotherinternshipproject.mapper.UserDTOMapper;
import com.victorello.yetanotherinternshipproject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserRestController.REST_URL)
public class UserRestController extends AbstractRestController<User, UserDAO, UserDTO, UserService, UserDTOMapper> {
    public static final String REST_URL = "/api/users";
}

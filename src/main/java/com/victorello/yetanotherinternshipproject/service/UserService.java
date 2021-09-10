package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.User;

import java.util.Optional;

public interface UserService extends AbstractService<User, UserDAO> {
    Optional<User> findByName(String name);
}

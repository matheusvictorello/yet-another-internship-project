package com.victorello.yetanotherinternshipproject.dao;

import com.victorello.yetanotherinternshipproject.domain.User;

import java.util.Optional;

public interface UserDAO extends AbstractDAO<User> {

    Optional<User> findByName(String name);
}

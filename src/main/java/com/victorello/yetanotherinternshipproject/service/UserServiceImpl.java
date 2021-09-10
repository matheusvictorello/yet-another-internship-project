package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDAO> implements UserService {

    @Override
    public Optional<User> findByName(String name) {
        return dao.findByName(name);
    }
}

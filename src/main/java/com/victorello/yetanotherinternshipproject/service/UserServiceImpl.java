package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDAO> implements UserService {
}

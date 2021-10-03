package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDAO> implements UserService {

    @Override
    public Optional<User> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Set<Project> getProjectsFromId(Long id) {
        return dao.getProjectsFromId(id);
    }

    @Override
    public Set<Task> getTasksFromId(Long id) {
        return dao.getTasksFromId(id);
    }

    @Override
    public Set<Card> getCardsFromId(Long id) {
        return dao.getCardsFromId(id);
    }
}

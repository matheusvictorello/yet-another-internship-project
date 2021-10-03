package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserService extends AbstractService<User, UserDAO> {

    Optional<User> findByName(String name);

    Set<Project> getProjectsFromId(Long id);

    Set<Task> getTasksFromId(Long id);

    Set<Card> getCardsFromId(Long id);
}

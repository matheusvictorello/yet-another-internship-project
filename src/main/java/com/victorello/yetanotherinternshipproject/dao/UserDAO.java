package com.victorello.yetanotherinternshipproject.dao;

import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface UserDAO extends AbstractDAO<User> {

    Optional<User> findByName(String name);

    @Query("SELECT p FROM Project p WHERE p.owner.id = :id")
    Set<Project> getProjectsFromId(@Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.project.owner.id = :id")
    Set<Task> getTasksFromId(@Param("id") Long id);

    @Query("SELECT c FROM Card c WHERE c.task.project.owner.id = :id")
    Set<Card> getCardsFromId(@Param("id") Long id);
}

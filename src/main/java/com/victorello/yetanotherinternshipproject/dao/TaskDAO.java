package com.victorello.yetanotherinternshipproject.dao;

import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface TaskDAO extends AbstractDAO<Task> {

    @Query("SELECT c FROM Card c WHERE c.task.id = :id")
    Set<Card> getCardsFromId(@Param("id") Long id);
}

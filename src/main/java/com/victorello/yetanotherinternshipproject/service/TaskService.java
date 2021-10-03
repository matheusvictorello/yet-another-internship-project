package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Task;

import java.util.Set;

public interface TaskService extends AbstractService<Task, TaskDAO> {

    Set<Card> getCardsFromId(Long id);
}

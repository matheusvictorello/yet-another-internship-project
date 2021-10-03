package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Task;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskServiceImpl extends AbstractServiceImpl<Task, TaskDAO> implements TaskService {

    @Override
    public Set<Card> getCardsFromId(Long id) {
        return dao.getCardsFromId(id);
    }
}

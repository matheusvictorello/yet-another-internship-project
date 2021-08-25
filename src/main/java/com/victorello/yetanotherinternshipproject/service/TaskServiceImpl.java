package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.domain.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractServiceImpl<Task, TaskDAO> implements TaskService {
}

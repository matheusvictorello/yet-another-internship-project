package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.dto.TaskDTO;
import com.victorello.yetanotherinternshipproject.mapper.TaskDTOMapper;
import com.victorello.yetanotherinternshipproject.service.TaskService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(TaskRestController.REST_URL)
public class TaskRestController extends AbstractRestController<Task, TaskDAO, TaskDTO, TaskService, TaskDTOMapper> {
    public static final String REST_URL = "/api/tasks";
}

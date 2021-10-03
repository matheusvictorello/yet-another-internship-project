package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.dto.ProjectDTO;
import com.victorello.yetanotherinternshipproject.dto.TaskDTO;
import com.victorello.yetanotherinternshipproject.mapper.ProjectDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.TaskDTOMapper;
import com.victorello.yetanotherinternshipproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(ProjectRestController.REST_URL)
public class ProjectRestController extends AbstractRestController<Project, ProjectDAO, ProjectDTO, ProjectService, ProjectDTOMapper> {
    public static final String REST_URL = "/api/projects";

    @Autowired
    private TaskDTOMapper taskDTOMapper;

    @GetMapping("/{id}/tasks")
    public ResponseEntity<Set<TaskDTO>> getProjects(@PathVariable("id") Long id) {
        Set<Task> taskSet = service.getTasksFromId(id);
        Set<TaskDTO> taskDTOSet = taskDTOMapper.toDTO(taskSet);
        return ResponseEntity.ok(taskDTOSet);
    }
}

package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;
import com.victorello.yetanotherinternshipproject.dto.CardDTO;
import com.victorello.yetanotherinternshipproject.dto.ProjectDTO;
import com.victorello.yetanotherinternshipproject.dto.TaskDTO;
import com.victorello.yetanotherinternshipproject.dto.UserDTO;
import com.victorello.yetanotherinternshipproject.mapper.CardDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.ProjectDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.TaskDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.UserDTOMapper;
import com.victorello.yetanotherinternshipproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(UserRestController.REST_URL)
public class UserRestController extends AbstractRestController<User, UserDAO, UserDTO, UserService, UserDTOMapper> {
    public static final String REST_URL = "/api/users";

    @Autowired
    private ProjectDTOMapper projectDTOMapper;

    @Autowired
    private TaskDTOMapper taskDTOMapper;

    @Autowired
    private CardDTOMapper cardDTOMapper;

    @GetMapping("/{id}/projects")
    public ResponseEntity<Set<ProjectDTO>> getProjects(@PathVariable("id") Long id) {
        Set<Project> projectSet = service.getProjectsFromId(id);
        Set<ProjectDTO> projectDTOSet = projectDTOMapper.toDTO(projectSet);
        return ResponseEntity.ok(projectDTOSet);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<Set<TaskDTO>> getTasks(@PathVariable("id") Long id) {
        Set<Task> taskSet = service.getTasksFromId(id);
        Set<TaskDTO> taskDTOSet = taskDTOMapper.toDTO(taskSet);
        return ResponseEntity.ok(taskDTOSet);
    }

    @GetMapping("/{id}/cards")
    public ResponseEntity<Set<CardDTO>> getCards(@PathVariable("id") Long id) {
        Set<Card> cardSet = service.getCardsFromId(id);
        Set<CardDTO> cardDTOSet = cardDTOMapper.toDTO(cardSet);
        return ResponseEntity.ok(cardDTOSet);
    }
}

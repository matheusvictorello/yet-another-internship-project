package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.dto.CardDTO;
import com.victorello.yetanotherinternshipproject.dto.TaskDTO;
import com.victorello.yetanotherinternshipproject.mapper.CardDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.TaskDTOMapper;
import com.victorello.yetanotherinternshipproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(TaskRestController.REST_URL)
public class TaskRestController extends AbstractRestController<Task, TaskDAO, TaskDTO, TaskService, TaskDTOMapper> {
    public static final String REST_URL = "/api/tasks";

    @Autowired
    private CardDTOMapper cardDTOMapper;

    @GetMapping("/{id}/cards")
    public ResponseEntity<Set<CardDTO>> getProjects(@PathVariable("id") Long id) {
        Set<Card> cardSet = service.getCardsFromId(id);
        Set<CardDTO> cardDTOSet = cardDTOMapper.toDTO(cardSet);
        return ResponseEntity.ok(cardDTOSet);
    }
}

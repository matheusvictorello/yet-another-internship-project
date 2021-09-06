package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.dto.TaskDTO;
import com.victorello.yetanotherinternshipproject.mapper.exceptions.InvalidReferenceIdException;
import com.victorello.yetanotherinternshipproject.service.CardService;
import com.victorello.yetanotherinternshipproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskDTOMapperImpl extends AbstractDTOMapperImpl<Task, TaskDTO> implements TaskDTOMapper {

    @Autowired
    private CardService cardService;

    @Autowired
    private ProjectService projectService;

    @Override
    public Task fromDTO(TaskDTO dto) {
        Optional<Project> optionalProject = projectService.findById(dto.getProjectId());
        if (optionalProject.isEmpty()) throw new InvalidReferenceIdException();
        Project project = optionalProject.get();

        Set<Card> cardSet = new HashSet<>();
        for (Long id : dto.getCardIdList()) {
            Optional<Card> optionalCard = cardService.findById(id);
            if (optionalCard.isEmpty()) throw new InvalidReferenceIdException();
            cardSet.add(optionalCard.get());
        }

        Task task = new Task();
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setProject(project);
        task.setCardSet(cardSet);

        return task;
    }

    @Override
    public TaskDTO toDTO(Task task) {
        Long projectId = task.getProject().getId();
        List<Long> projectIdList = task.getCardSet().stream().map(AbstractEntity::getId).toList();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setProjectId(projectId);
        taskDTO.setCardIdList(projectIdList);

        return taskDTO;
    }
}

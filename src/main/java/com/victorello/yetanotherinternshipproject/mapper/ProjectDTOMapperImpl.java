package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;
import com.victorello.yetanotherinternshipproject.dto.ProjectDTO;
import com.victorello.yetanotherinternshipproject.dto.UserDTO;
import com.victorello.yetanotherinternshipproject.service.TaskService;
import com.victorello.yetanotherinternshipproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectDTOMapperImpl extends AbstractDTOMapperImpl<Project, ProjectDTO> implements ProjectDTOMapper{

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Override
    public Project fromDTO(ProjectDTO dto) {
        Optional<User> optionalUser = userService.findById(dto.getOwnerId());
        if (optionalUser.isEmpty()) return null;
        User owner = optionalUser.get();

        Set<Task> taskSet = new HashSet<>();
        for (Long id : dto.getTaskIdList()) {
            Optional<Task> optionalTask = taskService.findById(id);
            if (optionalTask.isEmpty()) {
                return null;
            }
            taskSet.add(optionalTask.get());
        }

        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setOwner(owner);
        project.setTaskSet(taskSet);

        return project;
    }

    @Override
    public ProjectDTO toDTO(Project project) {
        List<Long> taskIdList = project.getTaskSet().stream().map(AbstractEntity::getId).toList();

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setOwnerId(project.getOwner().getId());
        projectDTO.setTaskIdList(taskIdList);

        return projectDTO;
    }
}

package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project, ProjectDAO> implements ProjectService {

    @Override
    public Set<Task> getTasksFromId(Long id) {
        return dao.getTasksFromId(id);
    }
}

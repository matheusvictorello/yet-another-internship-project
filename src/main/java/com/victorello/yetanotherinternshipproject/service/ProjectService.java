package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;

import java.util.Set;

public interface ProjectService extends AbstractService<Project, ProjectDAO> {

    Set<Task> getTasksFromId(Long id);
}

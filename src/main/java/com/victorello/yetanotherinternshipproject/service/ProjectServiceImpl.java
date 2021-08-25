package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.domain.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends AbstractServiceImpl<Project, ProjectDAO> implements ProjectService {
}

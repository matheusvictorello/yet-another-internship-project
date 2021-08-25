package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.dto.ProjectDTO;
import com.victorello.yetanotherinternshipproject.mapper.ProjectDTOMapper;
import com.victorello.yetanotherinternshipproject.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectRestController.REST_URL)
public class ProjectRestController extends AbstractRestController<Project, ProjectDAO, ProjectDTO, ProjectService, ProjectDTOMapper> {
    public static final String REST_URL = "/api/projects";
}

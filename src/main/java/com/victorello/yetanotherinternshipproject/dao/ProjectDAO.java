package com.victorello.yetanotherinternshipproject.dao;

import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProjectDAO extends AbstractDAO<Project> {

    @Query("SELECT t FROM Task t WHERE t.project.id = :id")
    Set<Task> getTasksFromId(@Param("id") Long id);
}

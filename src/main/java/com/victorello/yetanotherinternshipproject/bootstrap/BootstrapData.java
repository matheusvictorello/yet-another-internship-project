package com.victorello.yetanotherinternshipproject.bootstrap;

import com.victorello.yetanotherinternshipproject.dao.CardDAO;
import com.victorello.yetanotherinternshipproject.dao.ProjectDAO;
import com.victorello.yetanotherinternshipproject.dao.TaskDAO;
import com.victorello.yetanotherinternshipproject.dao.UserDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"dev", "!test"})
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private UserDAO    userDAO;
    private ProjectDAO projectDAO;
    private TaskDAO    taskDAO;
    private CardDAO    cardDAO;

    private List<User>    userList;
    private List<Project> projectList;
    private List<Task>    taskList;
    private List<Card>    cardList;

    @Override
    public void run(String ...args) {
        User user = new User("matheus");
        userDAO.save(user);
        userList.add(user);

        for (int i = 0; i < 2; i++) {
            Project project = new Project("project_" + i, user);
            projectDAO.save(project);
            projectList.add(project);

            for (int j = 0; j < 2; j++) {
                Task task = new Task("task_" + i + "_" + j, project);
                taskDAO.save(task);
                taskList.add(task);

                for (int k = 0; k < 2; k++) {
                    Card card = new Card("card_" + i + "_" + j + "_" + k, task);
                    cardDAO.save(card);
                    cardList.add(card);
                }

                taskDAO.save(task);
            }

            projectDAO.save(project);
        }

        userDAO.save(user);

        user = new User("bob");
        userDAO.save(user);
        userList.add(user);

        for (int i = 0; i < 2; i++) {
            Project project = new Project("project_" + i + 39, user);
            projectDAO.save(project);
            projectList.add(project);

            for (int j = 0; j < 10; j++) {
                Task task = new Task("task_" + i  + 39 + "_" + j + 22, project);
                taskDAO.save(task);
                taskList.add(task);

                for (int k = 0; k < 2; k++) {
                    Card card = new Card("card_" + i  + 39 + "_" + j  + 22 + "_" + k + 11, task);
                    cardDAO.save(card);
                    cardList.add(card);
                }

                taskDAO.save(task);
            }

            projectDAO.save(project);
        }

        userDAO.save(user);

        System.out.println("Done!");
    }
}

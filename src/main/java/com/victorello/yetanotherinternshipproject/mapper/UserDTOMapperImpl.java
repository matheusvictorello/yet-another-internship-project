package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.domain.Project;
import com.victorello.yetanotherinternshipproject.domain.User;
import com.victorello.yetanotherinternshipproject.dto.UserDTO;
import com.victorello.yetanotherinternshipproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDTOMapperImpl extends AbstractDTOMapperImpl<User, UserDTO> implements UserDTOMapper {

    @Autowired
    private ProjectService projectService;

    @Override
    public User fromDTO(UserDTO dto) {
        Set<Project> projectSet = new HashSet<>();
        for (Long id : dto.getProjectIdList()) {
            Optional<Project> optionalProject = projectService.findById(id);
            if (optionalProject.isEmpty()) return null;
            projectSet.add(optionalProject.get());
        }

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setProjectSet(projectSet);

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        List<Long> projectIdList = user.getProjectSet().stream().map(AbstractEntity::getId).toList();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setProjectIdList(projectIdList);

        return userDTO;
    }
}

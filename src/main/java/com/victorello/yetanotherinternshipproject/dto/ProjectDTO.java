package com.victorello.yetanotherinternshipproject.dto;

import com.victorello.yetanotherinternshipproject.domain.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class ProjectDTO extends AbstractDTO<Project> {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long ownerId;

    @Getter
    @Setter
    private List<Long> taskIdList = new ArrayList<>();
}

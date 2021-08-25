package com.victorello.yetanotherinternshipproject.dto;

import com.victorello.yetanotherinternshipproject.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class TaskDTO extends AbstractDTO<Task> {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long projectId;

    @Getter
    @Setter
    private List<Long> cardIdList = new ArrayList<>();
}

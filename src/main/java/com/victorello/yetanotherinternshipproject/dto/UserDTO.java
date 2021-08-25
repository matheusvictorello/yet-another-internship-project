package com.victorello.yetanotherinternshipproject.dto;

import com.victorello.yetanotherinternshipproject.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class UserDTO extends AbstractDTO<User> {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<Long> projectIdList = new ArrayList<>();
}

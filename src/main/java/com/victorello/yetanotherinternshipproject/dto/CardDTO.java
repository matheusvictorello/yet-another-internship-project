package com.victorello.yetanotherinternshipproject.dto;

import com.victorello.yetanotherinternshipproject.domain.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class CardDTO extends AbstractDTO<Card> {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long taskId;
}

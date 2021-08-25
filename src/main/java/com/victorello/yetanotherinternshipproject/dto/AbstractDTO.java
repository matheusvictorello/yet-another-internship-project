package com.victorello.yetanotherinternshipproject.dto;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
abstract public class AbstractDTO<T extends AbstractEntity> {

    @Getter
    @Setter
    private Long id;
}

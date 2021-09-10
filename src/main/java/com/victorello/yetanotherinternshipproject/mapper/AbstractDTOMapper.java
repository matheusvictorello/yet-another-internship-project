package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.dto.AbstractDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AbstractDTOMapper<T extends AbstractEntity, DTO extends AbstractDTO<T>> {

    T fromDTO(DTO dto);
    DTO toDTO(T t);

    Optional<T> fromDTO(Optional<DTO> dto);
    Optional<DTO> toDTO(Optional<T> t);

    List<T> fromDTO(List<DTO> dtos);
    List<DTO> toDTO(List<T> ts);

    Set<T> fromDTO(Set<DTO> dtos);
    Set<DTO> toDTO(Set<T> ts);
}

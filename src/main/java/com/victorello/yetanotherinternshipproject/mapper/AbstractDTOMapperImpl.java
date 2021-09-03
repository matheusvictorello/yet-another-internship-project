package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.dto.AbstractDTO;

import java.util.List;
import java.util.Optional;

abstract public class AbstractDTOMapperImpl<T extends AbstractEntity, DTO extends AbstractDTO<T>> implements AbstractDTOMapper<T, DTO> {

    @Override
    abstract public T fromDTO(DTO dto);

    @Override
    abstract public DTO toDTO(T t);

    @Override
    public Optional<T> fromDTO(Optional<DTO> dto) {
        return dto.map(this::fromDTO);
    }

    @Override
    public Optional<DTO> toDTO(Optional<T> t) {
        return t.map(this::toDTO);
    }

    @Override
    public List<T> fromDTO(List<DTO> dtos) {
        return dtos.stream().map(this::fromDTO).toList();
    }

    @Override
    public List<DTO> toDTO(List<T> ts) {
        return ts.stream().map(this::toDTO).toList();
    }
}

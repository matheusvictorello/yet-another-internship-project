package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.AbstractDAO;
import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.dto.AbstractDTO;
import com.victorello.yetanotherinternshipproject.mapper.AbstractDTOMapper;
import com.victorello.yetanotherinternshipproject.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

abstract public class AbstractRestController<
        T extends AbstractEntity,
        DAO extends AbstractDAO<T>,
        DTO extends AbstractDTO<T>,
        SERVICE extends AbstractService<T, DAO>,
        MAPPER extends AbstractDTOMapper<T, DTO>
        > {

    @Autowired
    protected SERVICE service;

    @Autowired
    protected MAPPER mapper;

    @GetMapping("")
    public ResponseEntity<Iterable<DTO>> getAll() {
        List<DTO> dtos = StreamSupport
                .stream(service.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable("id") Long id) {
        Optional<DTO> dto = mapper.toDTO(
                service.findById(id)
        );
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<DTO> createOne(@RequestBody DTO dto) {
        try {
            T t = mapper.fromDTO(dto);
            service.save(t);
            dto = mapper.toDTO(t);
            return ResponseEntity.ok(dto);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> updateById(@PathVariable("id") Long id, @RequestBody DTO dto) {
        try {
            T t = mapper.fromDTO(dto);
            t.setId(id);
            service.save(t);
            dto = mapper.toDTO(t);
            return ResponseEntity.ok(dto);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        Optional<T> ot = service.findById(id);

        if (ot.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        T t = ot.get();

        service.delete(t);

        return ResponseEntity.ok(true);
    }
}

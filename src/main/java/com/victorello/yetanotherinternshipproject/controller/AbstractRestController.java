package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.AbstractDAO;
import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import com.victorello.yetanotherinternshipproject.dto.AbstractDTO;
import com.victorello.yetanotherinternshipproject.mapper.AbstractDTOMapper;
import com.victorello.yetanotherinternshipproject.mapper.exceptions.InvalidReferenceIdException;
import com.victorello.yetanotherinternshipproject.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public ResponseEntity<Set<DTO>> getAll() {
        Set<DTO> dtos = StreamSupport
                .stream(service.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toSet());
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
        } catch (InvalidReferenceIdException | ConstraintViolationException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PostMapping("/find")
    public ResponseEntity<Set<DTO>> findAllById(@RequestBody List<Long> ids) {
        try {
            Set<DTO> dtoSet = new HashSet<>();

            for (Long id : ids) {
                Optional<T> optionalT = service.findById(id);

                if (optionalT.isEmpty()) return ResponseEntity.unprocessableEntity().build();
                T t = optionalT.get();
                DTO dto = mapper.toDTO(t);

                dtoSet.add(dto);
            }

            return ResponseEntity.ok(dtoSet);
        } catch (InvalidReferenceIdException | ConstraintViolationException e) {
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
        } catch (InvalidReferenceIdException | ConstraintViolationException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        Optional<T> ot = service.findById(id);

        if (ot.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        T t = ot.get();

        service.delete(t);

        return ResponseEntity.ok(true);
    }
}

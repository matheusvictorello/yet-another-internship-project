package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.AbstractDAO;
import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;

import java.util.Optional;

public interface AbstractService<T extends AbstractEntity, DAO extends AbstractDAO<T>> {

    void save(T t);

    void saveAll(Iterable<T> ts);

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    Long count();

    void deleteById(Long id);

    void delete(T t);
}

package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.AbstractDAO;
import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

abstract public class AbstractServiceImpl<T extends AbstractEntity, DAO extends AbstractDAO<T>> implements AbstractService<T, DAO> {

    @Autowired
    protected DAO dao;

    @Override
    public void save(T t) {
        dao.save(t);
    }

    @Override
    public void saveAll(Iterable<T> ts) {
        dao.saveAll(ts);
    }

    @Override
    public Optional<T> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return dao.findAll();
    }

    @Override
    public Long count() {
        return dao.count();
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(T t) {
        dao.delete(t);
    }
}

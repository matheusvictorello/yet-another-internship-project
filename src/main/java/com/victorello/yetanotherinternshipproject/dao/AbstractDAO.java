package com.victorello.yetanotherinternshipproject.dao;

import com.victorello.yetanotherinternshipproject.domain.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

public interface AbstractDAO<T extends AbstractEntity> extends CrudRepository<T, Long> {
}

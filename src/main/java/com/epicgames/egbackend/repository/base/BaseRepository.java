package com.epicgames.egbackend.repository.base;

import com.epicgames.egbackend.model.base.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BaseRepository<T extends BaseEntity, U> extends CrudRepository<T, UUID> {
    List<T> findAll();
}
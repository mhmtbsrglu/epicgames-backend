package com.epicgames.egbackend.service.base;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface BaseService<T> {
    CompletableFuture<T> getEntity(UUID id);
    CompletableFuture<List<T>> getAllEntities();
    CompletableFuture<T> updateEntity(T entity);
    void deleteEntity(UUID id);
    CompletableFuture<T> save(T entity);
}

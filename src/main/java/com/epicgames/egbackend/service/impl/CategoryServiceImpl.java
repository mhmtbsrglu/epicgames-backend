package com.epicgames.egbackend.service.impl;

import com.epicgames.egbackend.annotation.LogExecutionTime;
import com.epicgames.egbackend.exception.NotFoundException;
import com.epicgames.egbackend.model.Category;
import com.epicgames.egbackend.repository.CategoryRepository;
import com.epicgames.egbackend.service.CategoryService;
import com.epicgames.egbackend.service.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService  {

    private final CategoryRepository categoryRepository;

    @Override
    @LogExecutionTime
    public CompletableFuture<Category> getEntity(UUID id) {
        return CompletableFuture.completedFuture(categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category Notfound",String.format("ID: %s",id))
        ));
    }

    @Override
    @LogExecutionTime
    public CompletableFuture<List<Category>> getAllEntities() {
        return CompletableFuture.completedFuture(categoryRepository.findAll());
    }

    @Override
    @LogExecutionTime
    public CompletableFuture<Category> updateEntity(Category entity) {
        return CompletableFuture.completedFuture(categoryRepository.save(entity));
    }

    @Override
    public void deleteEntity(UUID id) {
        categoryRepository.deleteById(id);
    }

    @LogExecutionTime
    @Override
    public CompletableFuture<Category> save(Category entity) {
        super.save(entity);
        return CompletableFuture.completedFuture(categoryRepository.save(entity));
    }
}

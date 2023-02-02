package com.epicgames.egbackend.controller;

import com.epicgames.egbackend.model.Category;
import com.epicgames.egbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/category/")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping
    public CompletableFuture<List<Category>> getAll(){
        return categoryService.getAllEntities();
    }

    @GetMapping("{id}")
    public CompletableFuture<Category> getById(@PathVariable("id") UUID id){
        return categoryService.getEntity(id);
    }
    @PostMapping
    public CompletableFuture<Category> createCategory(@RequestBody Category category){
            return categoryService.save(category);
    }

}

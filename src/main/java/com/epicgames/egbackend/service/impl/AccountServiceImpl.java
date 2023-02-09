package com.epicgames.egbackend.service.impl;

import com.epicgames.egbackend.annotation.LogExecutionTime;
import com.epicgames.egbackend.exception.NotFoundException;
import com.epicgames.egbackend.model.Account;
import com.epicgames.egbackend.model.Category;
import com.epicgames.egbackend.repository.AccountRepository;
import com.epicgames.egbackend.repository.CategoryRepository;
import com.epicgames.egbackend.service.AccountService;
import com.epicgames.egbackend.service.CategoryService;
import com.epicgames.egbackend.service.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @LogExecutionTime
    public CompletableFuture<Account> getEntity(UUID id) {
        return CompletableFuture.completedFuture(accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category Notfound",String.format("ID: %s",id))
        ));
    }

    @Override
    @LogExecutionTime
    public CompletableFuture<List<Account>> getAllEntities() {
        return CompletableFuture.completedFuture(accountRepository.findAll());
    }

    @Override
    @LogExecutionTime
    public CompletableFuture<Account> updateEntity(Account entity) {
        return CompletableFuture.completedFuture(accountRepository.save(entity));
    }

    @Override
    public void deleteEntity(UUID id) {
        accountRepository.deleteById(id);
    }

    @LogExecutionTime
    @Override
    public CompletableFuture<Account> save(Account entity) {
        super.save(entity);
        return CompletableFuture.completedFuture(accountRepository.save(entity));
    }
}

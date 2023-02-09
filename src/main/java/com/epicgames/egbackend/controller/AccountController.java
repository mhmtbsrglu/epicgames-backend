package com.epicgames.egbackend.controller;

import com.epicgames.egbackend.model.Account;
import com.epicgames.egbackend.model.Category;
import com.epicgames.egbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/account/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @GetMapping
    public CompletableFuture<List<Account>> getAll(){
        return accountService.getAllEntities();
    }

    @GetMapping("{id}")
    public CompletableFuture<Account> getById(@PathVariable("id") UUID id){
        return accountService.getEntity(id);
    }
    @PostMapping
    public CompletableFuture<Account> createAccount(@RequestBody Account account){
            return accountService.save(account);
    }

}

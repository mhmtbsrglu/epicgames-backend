package com.epicgames.egbackend.repository;

import com.epicgames.egbackend.model.Account;
import com.epicgames.egbackend.model.Category;
import com.epicgames.egbackend.repository.base.BaseRepository;

import java.util.UUID;

public interface AccountRepository extends BaseRepository<Account, UUID> {

}

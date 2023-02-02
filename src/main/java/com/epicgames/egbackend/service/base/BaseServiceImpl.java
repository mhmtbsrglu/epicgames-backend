package com.epicgames.egbackend.service.base;

import com.epicgames.egbackend.model.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {


    @Override
    public CompletableFuture<T> getEntity(UUID id) {
        return null;
    }

    @Override
    public CompletableFuture<List<T>> getAllEntities() {
        return null;
    }

    @Override
    public CompletableFuture<T> updateEntity(T entity) {
        return null;
    }

    @Override
    public void deleteEntity(UUID id) {

    }

    @Override
    public CompletableFuture<T> save(T entity) {
        try{
            entity.setOperationSystem(InetAddress.getLocalHost().getHostName());
        }
        catch (Exception ex){
            log.error(ex.getMessage());
        }
        return CompletableFuture.completedFuture(entity);
    }
}

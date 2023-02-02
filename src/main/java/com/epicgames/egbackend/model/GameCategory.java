package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "game_categories")
public class GameCategory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Game.class)
    @JoinColumn(name = "game_id",nullable = false)
    private List<Game> games;


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "category_id",nullable = false)
    private List<Category> categories;
}

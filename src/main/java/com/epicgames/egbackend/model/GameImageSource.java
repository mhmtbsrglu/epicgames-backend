package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "game_images")
public class GameImageSource extends BaseEntity {
    private String path;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Game.class)
    @JoinColumn(name = "game_id",nullable = false)
    private List<Game> games;
}

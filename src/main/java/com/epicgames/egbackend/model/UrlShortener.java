package com.epicgames.egbackend.model;


import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "url_shorteners")
public class UrlShortener extends BaseEntity {
    private String match;
    private String customMatcher;
    @OneToOne(fetch = FetchType.LAZY,targetEntity = Game.class)
    @JoinColumn(name = "game_id",nullable = false)
    private Game game;

}

package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "game_ratings")
public class GameRating extends BaseEntity {
    private Long count;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Game.class)
    @JoinColumn(name = "game_id",nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = SubUser.class)
    @JoinColumn(name = "sub_user_id",nullable = false)
    private List<SubUser> subUsers;

}

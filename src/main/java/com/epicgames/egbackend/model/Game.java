package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Data
@Table(name = "games")
public class Game extends BaseEntity {
    private String title;
    private String detail;
    private double price;


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Developer.class)
    @JoinColumn(name = "developer_id",nullable = false)
    private List<Developer> developers;

    @OneToMany(mappedBy = "games",targetEntity = GameCategory.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GameCategory> gameCategories;

    @OneToMany(mappedBy = "games",targetEntity = GameImageSource.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GameImageSource> gameImageSources;
}

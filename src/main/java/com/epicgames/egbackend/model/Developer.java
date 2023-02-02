package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Data
@Table(name = "developers")
public class Developer extends BaseEntity {
    private UUID accountId;
    private String title;

    @OneToMany(mappedBy = "developers",targetEntity = Game.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Game> games;
}

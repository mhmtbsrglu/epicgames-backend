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

import java.util.List;
@Entity
@Data
@Table(name = "developers")
public class Developer extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY,targetEntity = Account.class)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;
    private String title;

    @OneToMany(mappedBy = "developers",targetEntity = Game.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Game> games;
}

package com.epicgames.egbackend.model;


import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tickets")
public class Ticket extends BaseEntity {
    private String reason;

    @Enumerated(EnumType.STRING)
    private WaitingStatus waitingStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = SubUser.class)
    @JoinColumn(name = "sub_user_id",nullable = false)
    private List<SubUser> subUsers;
}

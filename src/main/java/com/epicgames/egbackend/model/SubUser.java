package com.epicgames.egbackend.model;


import com.epicgames.egbackend.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sub_users")
public class SubUser extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    private String fullName;


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Account.class)
    @JoinColumn(name = "account_id",nullable = false)
    @JsonIgnore
    private List<Account> accounts;

    @OneToMany(mappedBy = "subUsers",fetch = FetchType.LAZY,targetEntity = Ticket.class)
    private List<Ticket> tickets;


}

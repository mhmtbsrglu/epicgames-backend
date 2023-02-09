package com.epicgames.egbackend.model;


import com.epicgames.egbackend.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "accounts",targetEntity = SubUser.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SubUser> subUsers;

    @OneToMany(mappedBy = "account",targetEntity = OTP.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OTP> otps;

    @JsonIgnore
    @OneToOne(targetEntity = Developer.class,mappedBy = "account",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Developer developer;


}

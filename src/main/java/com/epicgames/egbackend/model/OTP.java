package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "otp")
public class OTP extends BaseEntity {
    private String eightDigitCode;
    private Date expireDate;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Account.class)
    @JoinColumn(name = "account_id",nullable = false)
    @JsonIgnore
    private List<Account> account;
}

package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "security_configs")
public class SecurityConfig extends BaseEntity {
    private String match;

    @Enumerated(EnumType.STRING)
    private Role requiredRole;

    private boolean requiredBasicAuthentication;
    private boolean requiredBearerAuthentication;
}

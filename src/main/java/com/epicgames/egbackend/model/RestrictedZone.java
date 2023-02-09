package com.epicgames.egbackend.model;

import com.epicgames.egbackend.model.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "restricted_zones")
public class RestrictedZone extends BaseEntity {
    private String ipAddress;
    private int rateLimitCount;
    private boolean isBadWordsDetected;
    private Date expireDate;
    private boolean status = true;
}

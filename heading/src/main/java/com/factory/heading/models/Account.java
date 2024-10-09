package com.factory.heading.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "accounts", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "phone"}),
    @UniqueConstraint(columnNames = {"sku", "phone", "uniqueId"})
})
@Data
public class Account implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable = false)
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false)
    private String SKU;

    @Column(name = "accountName", columnDefinition = "varchar(45)", nullable = false)
    private String AccountName;

    @Column(name = "phone", columnDefinition = "varchar(12)")
    private String Phone = null;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String Address = null;

    @Column(name = "tax", columnDefinition = "varchar(10)")
    private String Tax = null;

    @Column(name = "cccd", columnDefinition = "varchar(12)")
    private String CCCD = null;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chain_id", nullable = false)
    private Chain chain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User CreatedBy;
}

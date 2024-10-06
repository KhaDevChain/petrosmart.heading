package com.factory.heading.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "chains", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "chainName"}),
    @UniqueConstraint(columnNames = {"sku", "chainName", "uniqueId"}),
})
@Data
public class Chain implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "chainName", columnDefinition = "varchar(30)", nullable = false)
    private String ChainName;

    @Column(name = "director", columnDefinition = "varchar(40)")
    private String Director = null;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;
}

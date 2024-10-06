package com.factory.heading.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "stations", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"stationName", "tax"}),
    @UniqueConstraint(columnNames = {"stationName", "tax", "sku"}),
    @UniqueConstraint(columnNames = {"stationName", "tax", "chainId"})
})
public class Station {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(15)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "stationName", columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String StationName;

    @Column(name = "address", columnDefinition = "varchar(120)", nullable = false)
    private String Address;

    @Column(name = "hotline", columnDefinition = "varchar(13)")
    private String Hotline = null;

    @Column(name = "tax", columnDefinition = "varchar(10)")
    private String Tax = null;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId", nullable = false)
    private Chain chain;
}

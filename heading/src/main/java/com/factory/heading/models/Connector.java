package com.factory.heading.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "connectors", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "uniqueId","chainId","stationId","fuelrectangularId","fuelpipeId"
    })
})
public class Connector {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String UniqueId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId", nullable = false)
    @JsonIgnore
    private Chain chain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId", nullable = false)
    private Station station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @Column(name = "statusName", columnDefinition = "varchar(50)", nullable = false)
    private String StationName;

    @Column(name = "fuelrectangularId", columnDefinition = "varchar(50)", nullable = false)
    private String FuelrectangularId;

    @Column(name = "fuelpipeId", columnDefinition = "varchar(50)", nullable = false)
    private String FuelpipeId;

    @Column(name = "deviceId", columnDefinition = "varchar(10)", nullable = false)
    private String DeviceId;

    @Column(name = "secrectKey", columnDefinition = "varchar(30)", nullable = false)
    private String SecrectKey;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();
}

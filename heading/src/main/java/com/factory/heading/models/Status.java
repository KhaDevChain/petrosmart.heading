package com.factory.heading.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "status", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"uniqueId", "statusName"})
})
@Data
public class Status {
    @Id
    @Column(name = "uniqueId", columnDefinition = "int(1)", nullable =  false)
    private int UniqueId;

    @Column(name = "statusName", columnDefinition = "varchar(50)", nullable = false)
    private String StatusName;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();
}

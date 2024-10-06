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
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "username"}),
    @UniqueConstraint(columnNames = {"sku", "username", "uniqueId"})
})
@Data
public class User implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "username", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String Username;

    @Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
    private String Password;

    @Column(name = "fullname", columnDefinition = "varchar(70)", nullable = false)
    private String Fullname;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @Column(name = "roleType", columnDefinition = "varchar(25)", nullable = false)
    private String RoleType;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permissionId")
    private Permisstion permisstion;
}

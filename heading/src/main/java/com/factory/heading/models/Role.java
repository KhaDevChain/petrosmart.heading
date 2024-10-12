package com.factory.heading.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UniqueId;

    @Column(name = "roleName", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String RoleName;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    // Nếu 1 role có nhiều permission
    // @ManyToMany(fetch = FetchType.EAGER)
    // @JsonIgnore
    // @JoinTable(name = "role_permission", 
    //            joinColumns = @JoinColumn(name = "role_id"), 
    //            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    // private Set<Permission> permissions;
}

package com.factory.heading.service;

import java.util.List;

import com.factory.heading.models.Permission;

public interface PermissionService {
    // LIST
    List<Permission> getPermissions();

    // OBJECT
    Permission findByGroupName(String groupName);
    Permission findById(String uniqueId);
}

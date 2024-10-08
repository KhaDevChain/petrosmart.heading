package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.heading.models.Permission;
import com.factory.heading.repository.PermissionRepo;
import com.factory.heading.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public List<Permission> getPermissions() {
        return permissionRepo.findAll();
    }

    @Override
    public Permission findByGroupName(String groupName) {
        return permissionRepo.findByGroupName(groupName).orElse(null);
    }

    @Override
    public Permission findById(String uniqueId) {
        return permissionRepo.findById(uniqueId).orElse(null);
    }
    
}

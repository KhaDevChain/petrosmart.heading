package com.factory.heading.service;

import java.util.List;

import com.factory.heading.models.Role;

public interface RoleService {
    Role findById(Long roleId);
    List<Role> getAllRoles();
}

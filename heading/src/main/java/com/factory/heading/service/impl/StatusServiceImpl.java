package com.factory.heading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.heading.models.Status;
import com.factory.heading.repository.StatusRepo;
import com.factory.heading.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepo statusRepo;

    @Override
    public List<Status> getStatuses() {
        return statusRepo.findAll();
    }

    @Override
    public Status geStatusById(int statusId) {
        return statusRepo.findById(statusId).orElse(null);
    }
    
}

package com.factory.heading.service;

import java.util.List;

import com.factory.heading.models.Status;

public interface StatusService {
    // OBJECT
    Status geStatusById(int statusId);

    // LIST
    List<Status> getStatuses();
}

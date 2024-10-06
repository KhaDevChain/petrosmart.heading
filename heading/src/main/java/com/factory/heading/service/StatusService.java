package com.factory.heading.service;

import java.util.List;

import com.factory.heading.models.Status;

public interface StatusService {
    // LIST
    List<Status> getStatuses();

    Status geStatusById(int statusId);
}

package com.factory.heading.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.heading.service._ParamService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class _ParamServiceImpl implements _ParamService {
    @Autowired
    HttpServletRequest request;

    @Override
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : value;
    }

    @Override
    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    @Override
    public double getDouble(String name, double defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : Double.parseDouble(value);
    }

    @Override
    public boolean getBoolean(String name, boolean defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : Boolean.parseBoolean(value);
    }

    @Override
    public LocalDateTime getDateTime(String name, LocalDateTime defaultValue) {
        String value = request.getParameter(name);
        return value == null ? defaultValue : LocalDateTime.parse(value);
    }
    
}

package com.factory.heading.service;

import java.time.LocalDateTime;

public interface _ParamService {
    String getString(String name, String defaultValue);
    int getInt(String name, int defaultValue);
    double getDouble(String name, double defaultValue);
    boolean getBoolean(String name, boolean defaultValue);
    LocalDateTime getDateTime(String name, LocalDateTime defaultValue);
}

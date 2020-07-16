package com.example.demo.forms;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class StatisticsForm {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @Override
    public String toString() {
        return "Creation date " + this.creationDateTime;
    }
}

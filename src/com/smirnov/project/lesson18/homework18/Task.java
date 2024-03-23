package com.smirnov.project.lesson18.homework18;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private static int countedId;
    private int id;
    private String title;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime closeTo;

    public Task(String title) {
        Objects.requireNonNull(title);
        id = countedId++;
        status = Status.NEW;
        createdAt = LocalDateTime.now();
        this.title = title;
    }

    // геттеры, сеттеры и д.т

    public enum Status {
        NEW, IN_PROGRESS, CLOSED
    }

    public void setStatus(Status status) {
        Objects.requireNonNull(status);
        this.status = status;
        if (status == Status.CLOSED) {
            closeTo = LocalDateTime.now();
        }
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCloseTo(LocalDateTime closeTo) {
        this.closeTo = closeTo;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCloseTo() {
        return closeTo;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", closeTo=" + closeTo +
                '}';
    }
}
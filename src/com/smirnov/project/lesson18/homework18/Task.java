package com.smirnov.project.lesson18.homework18;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Задача.
 */
public class Task implements Comparable<Task> {
    /**
     * Автоинкрементируемый счетчик.
     */
    private static int countedId;
    /**
     * Номер задачи.
     */
    private final int id;
    /**
     * Наименование задачи.
     */
    private final String title;
    /**
     * Статус задачи.
     */
    private Status status;
    /**
     * Дата и время создания задачи.
     */
    private final LocalDateTime createdAt;
    /**
     * Дата и время закрытия задачи.
     */
    private LocalDateTime closeTo;

    public Task(String title, LocalDateTime closeTo) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(closeTo);
        createdAt = LocalDateTime.now();
        if (!closeTo.isAfter(createdAt)) {
            throw new IllegalArgumentException();
        }
        id = countedId++;
        status = Status.NEW;
        this.closeTo = closeTo;
        this.title = title;
    }

    /**
     * Статусы задач.
     */
    public enum Status {
        NEW, IN_PROGRESS, CLOSED
    }

    public void setStatus(Status status) {
        Objects.requireNonNull(status);
        this.status = status;
    }

    public void setCloseTo(LocalDateTime closeTo) {
        Objects.requireNonNull(closeTo);
        if (!closeTo.isAfter(createdAt) || status == Status.CLOSED) {
            throw new IllegalArgumentException("Дата завершения должна быть позже даты создания. Нельзя изменить дату у уже завершенной задачи.");
        }
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

    @Override
    public int compareTo(Task otherTask) {
        Objects.requireNonNull(otherTask);
        if (this.closeTo.isBefore(otherTask.closeTo)) {
            return -1;
        } else if (this.closeTo.isAfter(otherTask.closeTo)) {
            return 1;
        }
        return 0;
    }
}
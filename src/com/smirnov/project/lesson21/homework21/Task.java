package com.smirnov.project.lesson21.homework21;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Задача.
 */
public class Task {

    /**
     * Статусы задач.
     */
    public enum Status {
        NEW, IN_PROGRESS, CLOSED
    }

    /**
     * Приоритеты задач
     */
    public enum Priority {
        IMPORTANT, UNIMPORTANT
    }

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
     * Приоритет задач.
     */
    private Priority priority;
    /**
     * Дата и время создания задачи.
     */
    private final LocalDateTime createdAt;
    /**
     * Дата и время закрытия задачи.
     */
    private LocalDateTime closeTo;

    public Task(String title, LocalDateTime closeTo, Priority priority) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(closeTo);
        Objects.requireNonNull(priority);
        createdAt = LocalDateTime.now();
        if (!closeTo.isAfter(createdAt)) {
            throw new IllegalArgumentException();
        }
        id = ++countedId;
        status = Status.NEW;
        this.closeTo = closeTo;
        this.title = title;
        this.priority = priority;
    }

    public void setStatus(Status status) {
        Objects.requireNonNull(status);
        if (this.status == Status.IN_PROGRESS && status == Status.NEW) {
            throw new IllegalArgumentException("Статус задачи понижаться не может");
        } else if (this.status == Status.CLOSED && (status == Status.NEW || status == Status.IN_PROGRESS))
            throw new IllegalArgumentException("Статус задачи понижаться не может");
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        Objects.requireNonNull(priority);
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task{id=%d, title='%s'}".formatted(id, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
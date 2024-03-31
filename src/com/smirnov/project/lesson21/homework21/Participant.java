package com.smirnov.project.lesson21.homework21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Исполнитель.
 */
public class Participant {
    /**
     * Автоинкрементируемый счетчик.
     */
    private static int countedId;
    /**
     * Номер исполнителя.
     */
    private final int id;
    /**
     * Имя исполнителя.
     */
    private String name;
    /**
     * Доступен в данный момент.
     */
    private boolean active;
    /**
     * Опыт, [год].
     */
    private int experience;
    /**
     * Максимальное количество задач, которое может выполнить.
     */
    private int maxTasks;

    private final List<Task> tasks = new ArrayList<>();

    /**
     * Конструктор создает исполнителя.
     *
     * @param name       Имя
     * @param active     Доступность
     * @param experience Опыт
     * @param maxTasks   Максимальное количество задач, которые может выполнить
     */
    public Participant(String name, boolean active, int experience, int maxTasks) {
        Objects.requireNonNull(name);
        if (experience < 0 && maxTasks < 1) throw new IllegalArgumentException("experience<0, maxTasks<1");
        id = ++countedId;
        this.name = name;
        this.active = active;
        this.experience = experience;
        this.maxTasks = maxTasks;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxTasks() {
        return maxTasks;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setMaxTasks(int maxTasks) {
        this.maxTasks = maxTasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant that)) return false;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Participant{id=%d, name='%s'}".formatted(id, name);
    }
}

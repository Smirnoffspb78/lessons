package com.smirnov.project.lesson21.homework21;

import static com.smirnov.project.lesson21.homework21.Task.Status.CLOSED;

/**
 * Задачи исполнителя
 */
public class TaskToParticipant {
    /**
     * Исполнитель.
     */
    private final Participant participant;
    /**
     * Задача.
     */
    private final Task task;
    /**
     * Прогресс, [%].
     */
    private int progress;

    /**
     * Конструктор добавляет задачу исполнителю.
     *
     * @param participant Исполнитель
     * @param task        Задача
     */
    public TaskToParticipant(Participant participant, Task task) {
        this.participant = participant;
        this.task = task;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Task getTask() {
        return task;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress > 100) {
            throw new IllegalArgumentException("progress>100");
        }
        this.progress = progress;
        if (progress == 100) {
            task.setStatus(CLOSED);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskToParticipant that)) return false;

        if (progress != that.progress) return false;
        if (!participant.equals(that.participant)) return false;
        return task.equals(that.task);
    }

    @Override
    public int hashCode() {
        int result = participant.hashCode();
        result = 31 * result + task.hashCode();
        result = 31 * result + progress;
        return result;
    }

    @Override
    public String toString() {
        return "{%s, %s}".formatted(participant, task);
    }
}

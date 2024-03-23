package com.smirnov.project.lesson18.homework18;

import java.util.List;

/**
 * Удаляет объекты из списка по определенному условию.
 */
public interface DeleteTask {
    /**
     *
     * @param listTask Список задач.
     * @return true/false если объект удален/не удален
     */
    boolean removeIf(List<Task> listTask);
}

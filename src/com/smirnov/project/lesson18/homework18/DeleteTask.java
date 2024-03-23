package com.smirnov.project.lesson18.homework18;

/**
 * Удаляет объекты из списка по определенному условию.
 */
@FunctionalInterface
public interface DeleteTask {
    /**
     *
     * @return true/false если объект удален/не удален
     */
    boolean removeIf();
}

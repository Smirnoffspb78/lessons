package com.smirnov.project.lesson13.homework13;

/**
 * Описывает поведение животного.
 */
public interface Action {
    /**
     * Выполняет действие.
     */
    void execute();

    /**
     * Переходит к следующему действию.
     *
     * @param action Следующее действие
     */
    boolean nextAction(Action action);
}

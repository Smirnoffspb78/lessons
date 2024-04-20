package com.smirnov.project.lesson13.homework13;

public abstract class Action implements Execute {

    /**
     * Действие.
     */
    private final Action action;

    /**
     * Конструктор создает возможность есть.
     *
     * @param action Следующее действие
     */

    protected Action(Action action) {
        this.action = action;
    }


    public void execute() {
        if (action != null) {
            nextAction();
        }
    }

    /**
     * Переходит к следующему действию.
     */

    private void nextAction() {
        action.execute();
    }
}

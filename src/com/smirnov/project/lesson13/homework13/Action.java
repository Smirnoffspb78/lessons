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

    /**
     * Переходит к следующему действию.
     *
     * @param action Следующее действие
     */

    public boolean nextAction(Action action) {
        if (action != null) {
            action.execute();
            return true;
        }
        return false;
    }

    public Action getAction() {
        return action;
    }
}

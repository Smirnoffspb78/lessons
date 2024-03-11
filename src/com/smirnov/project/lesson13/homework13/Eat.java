package com.smirnov.project.lesson13.homework13;

/**
 * Возможность есть.
 */
public class Eat implements Action {
    private final Action action;

    /**
     * Конструктор создает возможность есть.
     *
     * @param action Следующее действие
     */
    public Eat(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    /**
     * Ест.
     */
    @Override
    public void execute() {
        System.out.println("Animal to eat.");
        if (action != null) {
            nextAction(action);
        }
    }

    /**
     * Переходит к следующему действию.
     *
     * @param action Следующее действие
     */
    @Override
    public boolean nextAction(Action action) {
        if (action != null) {
            action.execute();
            return true;
        }
        return false;
    }
}

package com.smirnov.project.lesson13.homework13;

/**
 * Возможность есть.
 */
public class Eat extends Action {

    /**
     * Конструктор создает возможность есть.
     *
     * @param action Следующее действие
     */
    public Eat(Action action) {
        super(action);
    }

    /**
     * Ест.
     */
    @Override
    public void execute() {
        System.out.println("Animal to eat.");
        if (getAction() != null) {
            nextAction(getAction());
        }
    }

}

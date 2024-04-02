package com.smirnov.project.lesson13.homework13;

/**
 * Возможность пить.
 */
public class Drink extends Action {

    /**
     * Конструктор создает возможность пить.
     *
     * @param action Следующее действие
     */
    public Drink(Action action) {
        super(action);
    }

    /**
     * Пьет.
     */
    @Override
    public void execute() {
        System.out.println("Animal to drink.");
        nextAction(getAction());
    }
}

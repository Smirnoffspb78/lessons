package com.smirnov.project.lesson13.homework13;

import static java.lang.System.out;

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
        out.println("Animal to eat.");
        super.execute();
    }

}

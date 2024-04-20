package com.smirnov.project.lesson13.homework13;

import static java.lang.System.out;

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
        out.println("Animal to drink.");
        super.execute();
    }
}

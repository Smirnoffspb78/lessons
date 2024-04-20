package com.smirnov.project.lesson13.homework13;

import static java.lang.System.out;

/**
 * Возможность играть.
 */
public class Play extends Action {
    /**
     * Конструктор создает возможность играть.
     *
     * @param action Следующее действие
     */
    public Play(Action action) {
        super(action);
    }

    /**
     * Играет.
     */
    @Override
    public void execute() {
        out.println("Animal to play.");
        super.execute();
    }
}

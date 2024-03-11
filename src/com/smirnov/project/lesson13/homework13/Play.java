package com.smirnov.project.lesson13.homework13;

/**
 * Возможность играть.
 */
public class Play extends Eat implements Action {
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
        System.out.println("Animal to play.");
        nextAction(getAction());
    }
}

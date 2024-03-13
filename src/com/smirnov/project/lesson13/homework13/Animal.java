package com.smirnov.project.lesson13.homework13;

/**
 * Животное
 */
public class Animal {

    /**
     * Животное начинает выполнять действия.
     *
     * @param action Действие
     */
    public void doAction(Action action) {
        if (action != null) {
            System.out.println("Do all action.");
            action.execute();
        }
    }
}

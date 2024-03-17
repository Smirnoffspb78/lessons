package com.smirnov.project.lesson15.homework15;

/**
 * Исключение для проверки количества свободных мест фруктов на складе.
 */
public class MaxCountExceededException extends Exception {
    private final int numberOfEmptySlots;

    /**
     * Конструктор создается исключение.
     */
    public MaxCountExceededException(String message, int numberOfEmptySlots) {
        super(message);
        this.numberOfEmptySlots = numberOfEmptySlots;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + numberOfEmptySlots;
    }

    public int getNumberOfEmptySlots() {
        return numberOfEmptySlots;
    }
}

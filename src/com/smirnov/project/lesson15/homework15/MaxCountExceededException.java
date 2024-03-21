package com.smirnov.project.lesson15.homework15;

/**
 * Исключение для проверки количества свободных мест фруктов на складе.
 */
public class MaxCountExceededException extends Exception {
    private final int numberOfEmptySlots;
    private final String message;

    /**
     * Конструктор создается исключение.
     */
    public MaxCountExceededException(int numberOfEmptySlots) {
        message = "Свободных мест на складе: %d".formatted(numberOfEmptySlots);
        this.numberOfEmptySlots = numberOfEmptySlots;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getNumberOfEmptySlots() {
        return numberOfEmptySlots;
    }
}

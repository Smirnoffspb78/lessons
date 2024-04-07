package com.smirnov.project.lesson21.homework21;

/**
 * Статистика выполнения задач.
 *
 * @param numberOfClosed       Количество закрытых задач.
 * @param numberOfParticipants Общее количество исполнителей.
 * @param numberOfFailed       Количество просроченных и незакрытых задач.
 * @param numberOfInProgress   Количество выполняемых задач.
 */
public record TasksTrackerStatistic(int numberOfClosed, int numberOfParticipants, int numberOfFailed,
                                    int numberOfInProgress) {
    public TasksTrackerStatistic {
        if (numberOfClosed < 0 || numberOfParticipants < 0 || numberOfFailed < 0 || numberOfInProgress < 0) {
            throw new IllegalArgumentException("numberOfClosed < 0, numberOfParticipants < 0, numberOfFailed < 0, numberOfInProgress < 0");
        }
    }

    @Override
    public String toString() {
        return "TasksTrackerStatistic{Выполненные задачи: %d, Общее количество исполнителей: %d, Количество просроченных и незакрытых задач: %d, Количество выполняемых задач: %d}".formatted(numberOfClosed, numberOfParticipants, numberOfFailed, numberOfInProgress);
    }
}

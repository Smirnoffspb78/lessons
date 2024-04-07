package com.smirnov.project.lesson21.homework21;

import java.util.function.Predicate;

/**
 * Интерфейс, проверяющий возможность добавления задачи
 */
@FunctionalInterface
public interface TaskPredicate extends Predicate<Task> {
}

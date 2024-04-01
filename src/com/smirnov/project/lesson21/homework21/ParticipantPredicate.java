package com.smirnov.project.lesson21.homework21;

import java.util.function.Predicate;

/**
 * Интерфейс, проверяет возможность добавления исполнителя.
 */
@FunctionalInterface
public interface ParticipantPredicate extends Predicate<Participant> {
}

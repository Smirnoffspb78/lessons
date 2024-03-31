package com.smirnov.project.lesson21.homework21;

/**
 * Интерфейс, проверяет возможность добавления исполнителя.
 */
@FunctionalInterface
public interface ParticipantPredicate  {
    boolean testParticipant(Participant participant);
}

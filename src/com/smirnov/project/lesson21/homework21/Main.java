package com.smirnov.project.lesson21.homework21;

import java.time.LocalDateTime;

import static com.smirnov.project.lesson21.homework21.Task.Status.CLOSED;
import static com.smirnov.project.lesson21.homework21.Task.Status.NEW;

public class Main {

    public static void main(String[] args) {
        ParticipantPredicate participantPredicate = participant -> participant.getExperience() > 5;
        ParticipantPredicate participantPredicate1 = Participant::isActive;
        ParticipantPredicate participantPredicate2 = participant -> participant.getTasks().stream().noneMatch(participantLocal -> participantLocal.getStatus() != CLOSED);
        ParticipantPredicate[] participantPredicateAll = {participantPredicate, participantPredicate1, /*participantPredicate2*/};

        TaskPredicate taskPredicate = task -> task.getStatus() == NEW;

        TaskPredicate[] taskPredicateAll = {taskPredicate};

        Task task = new Task("Задача1", LocalDateTime.now().plusDays(4), Task.Priority.UNIMPORTANT);
        Task task2 = new Task("Задача2", LocalDateTime.now().plusDays(4), Task.Priority.UNIMPORTANT);
        Task task3 = new Task("Задача3", LocalDateTime.now().plusDays(4), Task.Priority.UNIMPORTANT);
        Task task4 = new Task("Задача4", LocalDateTime.now().plusDays(4), Task.Priority.UNIMPORTANT);
        Task task5 = new Task("Задача5", LocalDateTime.now().plusDays(4), Task.Priority.IMPORTANT);
        Task task6 = new Task("Задача6", LocalDateTime.now().plusDays(4), Task.Priority.IMPORTANT);


        Participant participant1 = new Participant("Иван", true, 6, 5);
        Participant participant2 = new Participant("Иван", true, 5, 5);
        Participant participant3 = new Participant("Иван", false, 6, 5);
        Participant participant4 = new Participant("Сергей", true, 6, 5);


        TaskTracker taskTracker = TaskTracker.withTitle("Трекер1").taskSettings(taskPredicateAll).participantSettings(participantPredicateAll);

        //Вызов методов без созданных объектов
        System.out.println(taskTracker);
        System.out.println(taskTracker.getStatistics());
        System.out.println("Метод groupTasksIdByStatusAndPriority" + taskTracker.groupTasksIdByStatusAndPriority());
        System.out.println("Метод filteredTasks" + taskTracker.filteredTasks(taskLocal -> taskLocal.getPriority() == Task.Priority.IMPORTANT));
        System.out.println(taskTracker.groupTasksByParticipantId());


        taskTracker.add(task, participant1);
        taskTracker.add(task, participant1); //не должно добавиться повторно
        taskTracker.add(task, participant2); //не должно добавиться, т.к. мало лет опыта
        taskTracker.add(task, participant3); //не должно добавиться, т.к. не активен

        System.out.println(taskTracker);
        taskTracker.add(task2, participant1);
        taskTracker.add(task3, participant1);
        taskTracker.add(task4, participant1);
        taskTracker.add(task5, participant1);
        taskTracker.add(task6, participant1); //Не должны добавиться, т.к. предел задач 5

        System.out.println(taskTracker);


        task.setStatus(CLOSED);
        taskTracker.add(task6, participant1); //Добавилась, т.к. "задача 1" стала Closed

        System.out.println(taskTracker);
        System.out.println(taskTracker.getStatistics()); //1, 1, 0, 0

        System.out.println("Метод groupTasksIdByStatusAndPriority" + taskTracker.groupTasksIdByStatusAndPriority());

        System.out.println("Метод filteredTasks" + taskTracker.filteredTasks(taskLocal -> taskLocal.getPriority() == Task.Priority.IMPORTANT));

        System.out.println(taskTracker.groupTasksByParticipantId());


        System.out.println("Добавление еще одного исполнителя в списки задач");

        taskTracker.add(task, participant4);
        taskTracker.add(task2, participant4);
        taskTracker.add(task3, participant4);

        System.out.println(taskTracker);

        System.out.println(taskTracker.getStatistics()); //1, 2, 0, 0

        System.out.println("Метод groupTasksIdByStatusAndPriority" + taskTracker.groupTasksIdByStatusAndPriority());

        System.out.println("Метод filteredTasks" + taskTracker.filteredTasks(taskLocal -> taskLocal.getPriority() == Task.Priority.UNIMPORTANT));

        System.out.println(taskTracker.groupTasksByParticipantId());
    }
}

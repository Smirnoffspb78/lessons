package com.smirnov.project.lesson21.homework21;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.smirnov.project.lesson21.homework21.Task.Status.CLOSED;
import static com.smirnov.project.lesson21.homework21.Task.Status.IN_PROGRESS;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class TaskTracker {

    /**
     * Наименование трекера задач
     */
    private final String name;
    /**
     * Список задач.
     */
    private final Set<TaskToParticipant> tasks = new HashSet<>();

    // taskPredicates - условия добавления задач. Тип данных определить самостоятельно
    // условие добавление задачи по умолчанию: задача должна быть открытой
    // может быть заменено методом taskSettings
    private final List<TaskPredicate> taskPredicates = new ArrayList<>();


    // participantPredicates - условия добавления исполнителей. Тип данных определить самостоятельно
    // условие добавление исполнителя по умолчанию: исполнитель должен быть
    // доступен по свойству active
    // может быть заменено методом participantSettings ???????????????????????????????? Как дополнить понятно, но заменить - по какому условию эта замена происходит????
    private final List<ParticipantPredicate> participantPredicates = new ArrayList<>();

    // конструктор не должен быть доступен вне класса
    private TaskTracker(String name) {
        taskPredicates.add(task -> task.getStatus() != CLOSED);
        participantPredicates.add(Participant::isActive);
        this.name = name;
    }

    // создание TaskTracker происходит вызовом статического метода withTitle,
    // метод принимает на вход название создает и возвращает экземпляр TaskTracker
    public static TaskTracker withTitle(String name) {
        Objects.requireNonNull(name);
        return new TaskTracker(name);
    }


    // TaskPredicate - функциональный интерфейс -
    // его абстрактный метод принимает задачу, возвращает ture или false
    public TaskTracker taskSettings(TaskPredicate[] predicates) {
        // predicates - массив типа TaskPredicate -
        // условия добавления задач,
        // например, predicates - задача должна быть срочной
        //                      - задача должна быть новой
        //                      - задача должна быть просроченной
        // все условия хранятся в TaskPredicate
        Arrays.stream(predicates)
                .filter(Objects::nonNull)
                .distinct()
                .forEach(taskPredicates::add);
        return this;
    }


    // ParticipantPredicate - функциональный интерфейс -
    // его абстрактный метод принимает задачу, возвращает ture или false
    public TaskTracker participantSettings(ParticipantPredicate[] predicates) {
        // predicates - массив типа ParticipantPredicate -
        // условия добавления исполнителей
        // например, predicates - опыт работы выше 5
        //                      - исполнитель должен быть доступен
        //                      - у исполнителя еще нет задач
        // все условия хранятся в participantPredicates
        Arrays.stream(predicates)
                .filter(Objects::nonNull)
                .distinct()
                .forEach(participantPredicates::add);
        return this;
    }

    public TaskTracker add(Task task, Participant participant) {
        // создается TaskToParticipant, если задача (task) и исполнитель (participant)
        // удовлетворяют требованиям taskPredicates и participantPredicates
        // TaskToParticipant добавляется в tasks
        Objects.requireNonNull(task);
        Objects.requireNonNull(participant);
        boolean check = participant.getMaxTasks() > participant.getTasks().stream()
                .filter(taskParticipant -> taskParticipant.getStatus() != CLOSED)
                .count()
                && !participant.getTasks().contains(task);

        if (check) {
            for (TaskPredicate taskPredicate : taskPredicates) {
                check = taskPredicate.test(task);
                if (!check) {
                    break;
                }
            }
            if (check) {
                for (ParticipantPredicate participantPredicate : participantPredicates) {
                    check = participantPredicate.test(participant);
                    if (!check) {
                        break;
                    }
                }
                if (check) {
                    tasks.add(new TaskToParticipant(participant, task));
                    participant.getTasks().add(task);
                }
            }
        }
        return this;
    }

    // возвращает статистику по текущему состоянию трекера
    public TasksTrackerStatistic getStatistics() {
        // реализовать метод, используя collectors api
        // посмотрите методы teeing() и reducing()
        return new TasksTrackerStatistic(
                (int) tasks.stream()
                        .map(TaskToParticipant::getTask)
                        .filter(task -> task.getStatus() == CLOSED)
                        .distinct()
                        .count(),
                (int) tasks.stream()
                        .map(TaskToParticipant::getParticipant)
                        .distinct()
                        .count(),
                (int) tasks.stream()
                        .map(TaskToParticipant::getTask)
                        .filter(task -> task.getStatus() != CLOSED && task.getCloseTo().isBefore(LocalDateTime.now()))
                        .distinct()
                        .count(),
                (int) tasks.stream()
                        .map(TaskToParticipant::getTask)
                        .filter(task -> task.getStatus() == IN_PROGRESS)
                        .distinct()
                        .count()
        );
    }

    // возвращает Map,
    // где ключи - идентификаторы исполнителей
    // значения - все его открытые задачи
    public Map<Integer, List<Task>> groupTasksByParticipantId() {
        return tasks.stream().filter(taskToParticipant -> taskToParticipant.getTask().getStatus() != CLOSED)
                .collect(groupingBy(
                        taskToParticipant -> taskToParticipant.getParticipant().getId(),
                        Collectors.mapping(TaskToParticipant::getTask, Collectors.toList())
                        ));
    }

    // возвращает Map,
    // где ключи - статус задачи
    // значения - Map,
    //      где ключи - статусы задач,
    //      значения - списки идентификаторов задач
    public Map<Task.Status, Map<Task.Priority, List<Integer>>> groupTasksIdByStatusAndPriority() {
        return tasks.stream()
                .map(TaskToParticipant::getTask)
                .distinct()
                .collect(groupingBy(
                        Task::getStatus,
                        groupingBy(
                                Task::getPriority,
                                mapping(Task::getId, Collectors.toList())
                        )
                ));
    }

    // возвращает неизменяемый список задач, прошедших проверку predicate
    public List<Task> filteredTasks(TaskPredicate predicate) {
        return tasks.stream()
                .map(TaskToParticipant::getTask)
                .filter(predicate)
                .distinct()
                .toList();
    }


    public Set<TaskToParticipant> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public List<TaskPredicate> getTaskPredicates() {
        return taskPredicates;
    }

    public List<ParticipantPredicate> getParticipantPredicates() {
        return participantPredicates;
    }

    @Override
    public String toString() {
        return "{%s', tasks=%s}".formatted(name, tasks);
    }
}

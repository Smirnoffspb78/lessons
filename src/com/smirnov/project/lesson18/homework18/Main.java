package com.smirnov.project.lesson18.homework18;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

import static com.smirnov.project.lesson18.homework18.Task.Status.CLOSED;

public class Main {

    public static void main(String[] args) {
        Task task0 = new Task("Task0", LocalDateTime.now().plusDays(2));
        Task task1 = new Task("Task1", LocalDateTime.now().plusDays(2));
        Task task2 = new Task("Task2", LocalDateTime.now().plusDays(2));
        Task task3 = new Task("Task3", LocalDateTime.now().plusDays(4));
        Task task4 = new Task("Task4", LocalDateTime.now().plusDays(4));

        List<Task> taskList = Arrays.asList(task0, task1, task2, task3, task4);

        Comparator<Task> comparatorByCloseTo = (o1, o2) -> {
            return o1.getCloseTo().compareTo(o2.getCloseTo());
        };

        // Задание №1
        // удалить задачи методом removeIf,
        // если они были созданы более месяца назад
        // и закрыты (статус CLOSED)

        int beginTasks = 1;
        taskList.removeIf(s -> s != null && s.getStatus() != null && s.getCreatedAt() != null &&
                !s.getCreatedAt().isBefore(LocalDateTime.now().minusMonths(beginTasks)) && s.getStatus() == CLOSED);

        // Задание №2
        // Перебрать список методом forEach,
        // вывести в консоль только открытые задачи,
        // которые нужно было завершить к текущему моменту

        taskList.forEach(s -> {
            if (s != null && s.getCloseTo() != null && s.getStatus() != CLOSED && s.getCloseTo().isBefore(LocalDateTime.now())) {
                System.out.print(s);
            }
        });


        // Задание №3
        // Перебрать список методом forEach,
        // вывести в консоль только задачи,
        // которые попадают в заданный диапазон дат
        System.out.println("Задача 3");

        LocalDateTime begin = LocalDateTime.now().minusDays(2);
        LocalDateTime end = LocalDateTime.now().plusDays(3);

        taskList.forEach(s -> {
            if (s != null && s.getCreatedAt() != null && s.getCloseTo() != null && !s.getCreatedAt().isBefore(begin) && !s.getCloseTo().isAfter(end)) {
                System.out.print(s);
            }
        });

        // Задание №4
        // Написать реализацию Function,
        // которая принимает на вход список задач,
        // и возвращает список с названиями
        // выполненных задач
        // в отсортированном по дате завершения виде

        task0.setCloseTo(LocalDateTime.now().plusDays(4));
        task0.setStatus(CLOSED);
        task1.setStatus(CLOSED);

        System.out.println("\nЗадача 4");

        Function<List<Task>, List<String>> function = (List<Task> localListTask) -> {
            Objects.requireNonNull(localListTask);
            if (localListTask.isEmpty()) {
                return new ArrayList<>();
            }
            List<Task> sortTaskList = new ArrayList<>();
            for (Task task : localListTask) {
                Objects.requireNonNull(task);
                Objects.requireNonNull(task.getCloseTo());
                if (task.getStatus() == CLOSED) {
                    sortTaskList.add(task);
                }
            }
            sortTaskList.sort(comparatorByCloseTo);
            List<String> sortTaskListWithName = new ArrayList<>(sortTaskList.size());
            for (Task task : sortTaskList) {
                sortTaskListWithName.add(task.getTitle());
            }
            return sortTaskListWithName;
        };
        System.out.println(function.apply(taskList));
    }
}

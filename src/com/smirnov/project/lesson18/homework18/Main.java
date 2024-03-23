package com.smirnov.project.lesson18.homework18;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static com.smirnov.project.lesson18.homework18.Task.Status.CLOSED;
import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
        Task task0 = new Task("Task0", LocalDateTime.now().plusDays(2));
        Task task1 = new Task("Task1", LocalDateTime.now().plusDays(2));
        Task task2 = new Task("Task2", LocalDateTime.now().plusDays(2));
        Task task3 = new Task("Task3", LocalDateTime.now().plusDays(2));
        Task task4 = new Task("Task4", LocalDateTime.now().plusDays(2));

        List<Task> taskList = new ArrayList<>(asList(task0, task1, task2, task3, task4));
        // Задание №1
        // удалить задачи методом removeIf,
        // если они были созданы более месяца назад
        // и закрыты (статус CLOSED)

        DeleteTask deleteTask = () -> {
            Objects.requireNonNull(taskList);
            if (taskList.isEmpty()) {
                return false;
            }
            List<Task> newTaskList = new ArrayList<>();
            for (Task task : taskList) {
                if (task == null || task.getStatus() == null || task.getCreatedAt() == null) {
                    throw new NullPointerException("task==null, status()==null, createdAt()==null)");
                }
                if (!task.getCreatedAt().isBefore(LocalDateTime.now().minusMonths(1)) && task.getStatus() != CLOSED) {
                    newTaskList.add(task);
                }
            }
            if (newTaskList.size() != taskList.size()) {
                taskList.clear();
                taskList.addAll(newTaskList);
            }
            return newTaskList.size() != taskList.size();
        };

        // Задание №2
        // Перебрать список методом forEach,
        // вывести в консоль только открытые задачи,
        // которые нужно было завершить к текущему моменту

        PrintTask printTask = () -> {
            Objects.requireNonNull(taskList);
            int localCounter = 0;
            for (Task task : taskList) {
                if (task == null || task.getCloseTo() == null) {
                    throw new NullPointerException("task==null, closeTo()==null)");
                }
                if (task.getStatus() != CLOSED && task.getCloseTo().isBefore(LocalDateTime.now())) {
                    localCounter++;
                    System.out.print(task);
                }
            }
            if (localCounter == 0) {
                System.out.println("List is Empty");
            }
        };

        // Задание №3
        // Перебрать список методом forEach,
        // вывести в консоль только задачи,
        // которые попадают в заданный диапазон дат


        LocalDateTime begin = LocalDateTime.now().minusDays(2);
        LocalDateTime end = LocalDateTime.now();

        PrintTask printTask1 = () -> {
            Objects.requireNonNull(taskList);
            int localCounter = 0;
            for (Task task : taskList) {
                if (task == null || task.getCreatedAt() == null || task.getCloseTo() == null) {
                    throw new NullPointerException("task=null, createdAt=null, closeTo=null");
                }
                if (!task.getCreatedAt().isAfter(begin) && !task.getCloseTo().isBefore(end)) {
                    System.out.print(task);
                    localCounter++;
                }
            }
            if (localCounter == 0) {
                System.out.println("List is Empty");
            }
        };

        // Задание №4
        // Написать реализацию Function,
        // которая принимает на вход список задач,
        // и возвращает список с названиями
        // выполненных задач
        // в отсортированном по дате завершения виде

        task0.setCloseTo(LocalDateTime.now().plusDays(4));
        task0.setStatus(CLOSED);
        task1.setStatus(CLOSED);

        Function<List<Task>, List<String>> function = (List<Task> localListTask) -> {
            Objects.requireNonNull(localListTask);
            if (localListTask.isEmpty()) {
                return new ArrayList<>();
            }
            List<Task> sortTaskList = new ArrayList<>();
            for (Task task : localListTask) {
                Objects.requireNonNull(task);
                Objects.requireNonNull(task.getCloseTo());
                if (task.getStatus() == CLOSED) sortTaskList.add(task);
            }
            Task[] taskArray = sortTaskList.toArray(new Task[0]);
            sort(taskArray);
            List<String> sortTaskListWithName = new ArrayList<>(taskArray.length);
            for (Task task : taskArray) {
                sortTaskListWithName.add(task.getTitle());
            }
            return sortTaskListWithName;
        };
    }
}

package com.smirnov.project.lesson18.homework18;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.smirnov.project.lesson18.homework18.Task.Status.CLOSED;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        Task task1 = new Task("Task0");
        Task task2 = new Task("Task1");
        Task task3 = new Task("Task2");
        Task task4 = new Task("Task3");
        Task task5 = new Task("Task4");

        task1.setCreatedAt(LocalDateTime.now().minusMonths(2));
        task1.setCloseTo(LocalDateTime.now().minusDays(1));


        List<Task> taskList = new ArrayList<>(asList(task1, task2, task3, task4, task5));
        // Задание №1
        // удалить задачи методом removeIf,
        // если они были созданы более месяца назад
        // и закрыты (статус CLOSED)



        //Метод удаляет задачи, если они были созданы более месяца назад
        DeleteTask deleteTask = (List<Task> taskListLocal) -> {
            Objects.requireNonNull(taskListLocal);
            if (taskListLocal.isEmpty()) {
                return false;
            }
            List<Task> newTaskList = new ArrayList<>();
            for (Task task : taskListLocal) {
                Objects.requireNonNull(task);
                if (!task.getCreatedAt().isBefore(LocalDateTime.now().minusMonths(1)) && task.getStatus() != CLOSED) {
                    newTaskList.add(task);
                }
            }
            taskListLocal.clear();
            taskListLocal.addAll(newTaskList);
            return newTaskList.size() == taskListLocal.size();
        };

        System.out.println("Задачи до удаления"+taskList);
        deleteTask.removeIf(taskList);
        System.out.println("Задачи после удаления"+taskList);
    }

}

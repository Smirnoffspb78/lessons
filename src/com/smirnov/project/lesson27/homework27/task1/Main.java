package com.smirnov.project.lesson27.homework27.task1;

import java.util.stream.IntStream;

<<<<<<< HEAD
public class Main {

    public static void main(String[] args) {
        ReadingEvent[] readingEvents = new ReadingEvent[args.length];
        IntStream.range(0, args.length).forEach(i -> {
            readingEvents[i] = new ReadingEvent(args[i], 1, "::", 7);
            readingEvents[i].start();
        });
       
=======
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        ReadingEvents[] readingEvents = new ReadingEvents[args.length];
        Thread[] threadsReadingEvents = new Thread[args.length];
        IntStream.range(0, args.length).forEach(i -> {
            readingEvents[i] = new ReadingEvents(args[i], 1, "::", 7);
            threadsReadingEvents[i] = new Thread(readingEvents[i]);
            threadsReadingEvents[i].start();
        });
        int allCountPriority = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                threadsReadingEvents[i].join(2000);
                allCountPriority += readingEvents[i].getCountPriority();
            } catch (InterruptedException e) {
                out.println("Поток умер");
            }
        }
        out.println("Общее количество событий с приоритетом больше 7: " + allCountPriority);
>>>>>>> origin/HomeWork27
    }
}

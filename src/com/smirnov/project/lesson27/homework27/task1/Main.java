package com.smirnov.project.lesson27.homework27.task1;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        ReadingEvent[] readingEvents = new ReadingEvent[args.length];
        IntStream.range(0, args.length).forEach(i -> {
            readingEvents[i] = new ReadingEvent(args[i], 1, "::", 7);
            readingEvents[i].start();
        });
       
    }
}

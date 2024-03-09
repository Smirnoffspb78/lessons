package com.smirnov.project.courseproject1;

import java.time.LocalDate;

import static com.smirnov.project.courseproject1.Fitness.*;
import static com.smirnov.project.courseproject1.TypeSeasonTicket.DAY_TIME;
import static com.smirnov.project.courseproject1.TypeSeasonTicket.FULL_TIME;

public class Application {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().plusDays(1);
        OwnerSeasonTicket person = new OwnerSeasonTicket("Иван", "Иванов", 2024);
        //Создание массива абонементов для проверки наполняемости
        SeasonTicket[] seasonTicketOneTime = new SeasonTicket[21];
        for (int i = 0; i < seasonTicketOneTime.length; i++) {
            seasonTicketOneTime[i] = new SeasonTicket(person);
            addTicket(GYM, seasonTicketOneTime[i]);
        }
        printAllSeasonTicket();

        System.out.println("Проверка наполняемости дефолтными именами и последующим заполнение фактическими именами");
        GYM.addDefaultTicket();
        System.out.println(addTicket(GYM, seasonTicketOneTime[0]));
        System.out.println("Повторное добавление в одну из зон");
        System.out.println(addTicket(GYM, seasonTicketOneTime[0]));
        System.out.println(addTicket(SWIMMING_POOL, seasonTicketOneTime[0]));
        printAllSeasonTicket();
        System.out.println("Добавление в недоступную группу");
        System.out.println(addTicket(GROUP_CLASSES, seasonTicketOneTime[1]));
        System.out.println("Добавление невалидных значений");
        System.out.println(addTicket(null, seasonTicketOneTime[1]));
        System.out.println(addTicket(GROUP_CLASSES, null));

        SeasonTicket seasonTicketDayTime = new SeasonTicket(localDate, person, DAY_TIME);
        System.out.println("Добавление в недопустимую группу");
        System.out.println(addTicket(SWIMMING_POOL, seasonTicketDayTime));

        System.out.println("Добавление в допустимую группу");
        System.out.println(addTicket(GYM, seasonTicketDayTime));

        SeasonTicket seasonTicketFullTime = new SeasonTicket(localDate, person, FULL_TIME);
        System.out.println(addTicket(GROUP_CLASSES, seasonTicketFullTime));
        printAllSeasonTicket();
    }

}


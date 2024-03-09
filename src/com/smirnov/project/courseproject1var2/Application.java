package com.smirnov.project.courseproject1var2;

import java.time.LocalDate;

import static com.smirnov.project.courseproject1var2.TypeFitness.*;
import static com.smirnov.project.courseproject1var2.TypeMembership.DAY_TIME;
import static com.smirnov.project.courseproject1var2.TypeMembership.FULL_TIME;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness();
        LocalDate localDate = LocalDate.now().plusDays(1);
        OwnerMembership person = new OwnerMembership("Иван", "Иванов", 2024);
        System.out.println(person.getName());
        //Создание массива абонементов для проверки наполняемости
        Membership[] membershipOneTime = new Membership[21];
        for (int i = 0; i < membershipOneTime.length; i++) {
            membershipOneTime[i] = new Membership(localDate, person, TypeMembership.ONE_TIME);
            fitness.addTicket(GYM, membershipOneTime[i]);
        }
        fitness.printAllSeasonTicket();

        System.out.println("Проверка наполняемости дефолтными именами и последующим заполнение фактическими именами");
        fitness.addDefaultTicket(GYM);
        System.out.println(fitness.addTicket(GYM, membershipOneTime[0]));
        System.out.println("Повторное добавление в одну из зон");
        System.out.println(fitness.addTicket(GYM, membershipOneTime[0]));
        System.out.println(fitness.addTicket(SWIMMING_POOL, membershipOneTime[0]));
        fitness.printAllSeasonTicket();
        System.out.println("Добавление в недоступную группу");
        System.out.println(fitness.addTicket(GROUP_CLASSES, membershipOneTime[1]));
        System.out.println("Добавление невалидных значений");
        System.out.println(fitness.addTicket(null, membershipOneTime[1]));
        System.out.println(fitness.addTicket(GROUP_CLASSES, null));

        Membership membershipDayTime = new Membership(localDate, person, DAY_TIME);
        System.out.println("Добавление в недопустимую группу");
        System.out.println(fitness.addTicket(SWIMMING_POOL, membershipDayTime));

        System.out.println("Добавление в допустимую группу");
        System.out.println(fitness.addTicket(GYM, membershipDayTime));

        Membership membershipFullTime = new Membership(localDate, person, FULL_TIME);
        System.out.println(fitness.addTicket(GROUP_CLASSES, membershipFullTime));
        fitness.printAllSeasonTicket();
    }

}


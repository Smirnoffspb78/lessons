package com.smirnov.project.lesson09.homework09;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Train train = new Train(10, 0, 1, true);
        Train train2 = new Train(10, 2, 2, true, 200);
        Train train3 = new Train(10, 3, 3, true, 200);
        Train train4 = new Train(10, 3, 3, true, 200);
        Train train5 = new Train(10, 4, 3, true, 200);
        Train train6 = new Train(10, 4, 3, true, 200);


        System.out.println(train.getWearLevel());
        Workshop workshop = new Workshop(5);


        System.out.println(workshop.addVehicles(train));
        System.out.println(workshop.addVehicles(train2));
        System.out.println(workshop.addVehicles(train3));
        System.out.println(workshop.addVehicles(train4));
        System.out.println(workshop.addVehicles(train5));
        System.out.println(workshop.addVehicles(train6));

        System.out.println(Arrays.toString(workshop.getVehicles()));

        workshop.repairAll();

        System.out.println(Arrays.toString(workshop.getVehicles()));

        System.out.println(train.getWearLevel());
        System.out.println(train2.getWearLevel());
        System.out.println(train3.getWearLevel());
        System.out.println(train4.getWearLevel());
        System.out.println(train5.getWearLevel());
        System.out.println(train6.getWearLevel());

        workshop.repairAll();
        System.out.println(Arrays.toString(workshop.getVehicles()));

        Workshop workshop2 = new Workshop(5);
        Train train7 = new Train(10, 5, 1, true);
        Train train8 = new Train(10, 4, 2, true, 200);
        Train train9 = new Train(10, 3, 3, true, 200);
        Train train10 = new Train(10, 3, 3, true, 200);
        Train train11 = new Train(10, 4, 3, true, 200);
        Train train12 = new Train(10, 4, 3, true, 200);

        System.out.println(workshop2.addVehicles(train7));
        System.out.println(workshop2.addVehicles(train8));
        System.out.println(workshop2.addVehicles(train9));
        System.out.println(workshop2.addVehicles(train10));
        System.out.println(workshop2.addVehicles(train11));
        System.out.println(workshop2.addVehicles(train12));

        System.out.println(Arrays.toString(workshop2.getVehicles()));
        System.out.println(workshop2.getLengthWorkshop());

        workshop2.repairAllFull();

        System.out.println(Arrays.toString(workshop2.getVehicles()));
        System.out.println(workshop2.getCounter());
        System.out.println(train12.getWearLevel());


        Bicycle bicycle = new Bicycle(1001, 57);

        Bicycle bicycle1 = new Bicycle(25, 1002, 30, 4, "Шоосейный");

        System.out.println(bicycle.getNumberWheel() + "" + bicycle.getType());
        System.out.println(bicycle1.getType() + "" + bicycle1.getNumberWheel() + "" + bicycle1.getType());
        bicycle1.repair();
        System.out.println(bicycle1.getWearLevel());


        Scooter scooter = new Scooter(153, 27, false);
        System.out.println(scooter.getNumberWheel());
        System.out.println(scooter.getSpeedMax());
        System.out.println(scooter.getType());

        Scooter scooter1 = new Scooter(15, 153, 25, true);
        System.out.println(scooter1.getSpeedMax());

        Workshop workshop3 = new Workshop(4);
        workshop3.addVehicles(train6);
        workshop3.addVehicles(bicycle1);
        workshop3.addVehicles(scooter1);
        workshop3.addVehicles(scooter);


        System.out.println(Arrays.toString(workshop3.getVehicles()));
        System.out.println(scooter.getWearLevel());
        workshop3.repairAll();

        System.out.println(train6.getWearLevel());
        System.out.println(bicycle1.getWearLevel());
        System.out.println(scooter.getWearLevel());
        System.out.println(scooter1.getWearLevel());

        workshop3.repairAllFull();

        System.out.println(train6.getWearLevel());
        System.out.println(bicycle1.getWearLevel());
        System.out.println(scooter.getWearLevel());
        System.out.println(scooter1.getWearLevel());


    }
}

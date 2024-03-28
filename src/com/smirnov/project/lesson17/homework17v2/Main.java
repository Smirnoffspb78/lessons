package com.smirnov.project.lesson17.homework17v2;

import com.smirnov.project.lesson14.vehicle.Bus;
import com.smirnov.project.lesson14.vehicle.Car;
import com.smirnov.project.lesson14.vehicle.Repaintable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(Repaintable.Color.BLACK, "AA111A");
        Car car2=new Car(Repaintable.Color.RED, "AA222A");
        Car car3=new Car(Repaintable.Color.BLUE, "AA223A");
        Car car4=new Car(null, "AA223A");


        car2.setLevelOfWare(30);
        car.setLevelOfWare(70);

        Bus bus = new Bus("AA111A");
        Bus bus2 = new Bus("AA222A");
        bus.setLevelOfWare(40);
        bus2.setLevelOfWare(60);

        Map<String, Car> carsMap=new HashMap<>();
        carsMap.put(car.getNumber(), car);
        carsMap.put(car2.getNumber(), car2);

        Map<String, Bus> busMap=new HashMap<>();
        busMap.put(bus.getNumber(), bus);
        busMap.put(bus2.getNumber(), bus2);

        //Task1
        System.out.println(HomeWork17v2.vehiclesWithLevelOfWear(carsMap, 50));
        System.out.println(HomeWork17v2.vehiclesWithLevelOfWear(busMap, 50));

        System.out.println(HomeWork17v2.vehiclesWithLevelOfWear2(carsMap, 50));
        System.out.println(HomeWork17v2.vehiclesWithLevelOfWear2(busMap, 50));

        //Task2
        List<Car> carRepaint=new ArrayList<>(asList(car, car2, car3, car4));
        Map<Repaintable.Color, List<Car>> paint=new HashMap<>();
        paint.put(Repaintable.Color.BLACK, new ArrayList<>());
        paint.put(Repaintable.Color.RED, new ArrayList<>());
        paint.put(Repaintable.Color.GOLD, new ArrayList<>());
        System.out.println("Мапа до заполнения"+paint);
        HomeWork17v2.repaintVehicle(carRepaint, paint);
        System.out.println("Мапа после заполнения"+paint);

        //Task3
        List<Car> carList = new ArrayList<>(asList(car, car2));
        List<Bus> busList = new ArrayList<>(asList(bus, bus2));

        System.out.println(HomeWork17v2.vehicleRepair(carList));
        System.out.println(HomeWork17v2.vehicleRepair(busList));

        System.out.println(HomeWork17v2.vehicleRepair2(carList));
        System.out.println(HomeWork17v2.vehicleRepair2(busList));

    }
}

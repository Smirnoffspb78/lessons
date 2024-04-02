package com.smirnov.project.lesson22;

import static java.lang.Math.abs;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        /*NutritionFacts milk = new NutritionFacts("молоко");*/
        // milk.setFat(10);
        NutritionFacts milk = new NutritionFacts.Builder("молоко")
                .fat(10) // жирность
                .calories(30)
                .build(); // создает и возвращает NutritionFacts

        // NutritionFacts meat = new NutritionFacts("мясо");
        // meat.setCalories(300);
        // meat.setServings(200);
        // meat.setFat(80);
      /*  NutritionFacts meat = new NutritionFacts.Builder("мясо")
                .calories(300) // калории
                .servings(200) // порции
                .fat(80) // жирность
                .build(); // создает и возвращает NutritionFacts
    }*/
        out.println(milk);

        // Датчик может информировать о
        // повышении или понижении температуры
        // Когда в датчике меняется температура (Math.random())
        // экземпляры red, yellow и green реагируют
        // на данные изменения, каждый своим способом (sout)

        // red начинает реагировать на повышении температуры,
        // начиная с 300С, далее каждые 50С

        // yellow начинает реагировать на повышении температуры,
        // начиная с 200С, далее каждые 30С

        // green начинает реагировать на повышении температуры,
        // начиная с 100С, далее каждые 10С

        Reactionable red = new Reactionable() {
            private double currentTemperature;

            @Override
            public void react(double value) {
                final int initialTemperature = 300;
                int differenceTemperature = 50;
                if (currentTemperature < initialTemperature && value > initialTemperature) {
                    out.println("Красный.Температура " + value + " oC");
                    currentTemperature = value;
                } else if (currentTemperature >= initialTemperature && abs(currentTemperature - value) >= differenceTemperature) {
                    out.println("Красный.Температура " + value + " oC");
                    currentTemperature = value;
                }
            }

            public double getCurrentTemperature() {
                return currentTemperature;
            }
        };
        Reactionable green = new Reactionable() {
            private double currentTemperature;

            @Override
            public void react(double value) {
                final int initialTemperature = 100;
                int differenceTemperature = 10;
                if (currentTemperature < initialTemperature && value > initialTemperature) {
                    out.println("Зеленый.Температура " + value + " oC");
                    currentTemperature = value;
                } else if (currentTemperature >= initialTemperature && abs(currentTemperature - value) >= differenceTemperature) {
                    out.println("Зеленый.Температура " + value + " oC");
                    currentTemperature = value;
                }
            }

            public double getCurrentTemperature() {
                return currentTemperature;
            }
        };

        Reactionable yellow = new Reactionable() {
            private double currentTemperature;

            @Override
            public void react(double value) {
                final int initialTemperature = 200;
                int differenceTemperature = 30;
                if (currentTemperature < initialTemperature && value > initialTemperature) {
                    out.println("Желтый.Температура " + value + " oC");
                    currentTemperature = value;
                } else if (currentTemperature >= initialTemperature && abs(currentTemperature - value) >= differenceTemperature) {
                    out.println("Желтый.Температура " + value + " oC");
                    currentTemperature = value;
                }
            }

            public double getCurrentTemperature() {
                return currentTemperature;
            }
        };

        Sensor sensor = new Sensor();
        sensor.addReactionable(red);
        sensor.addReactionable(yellow);
        sensor.addReactionable(green);

        var n = 20;
        for (int i = 0; i < n; i++) {
            sensor.temperatureRequest();
            out.println(sensor.getTemperature());
        }
    }
}

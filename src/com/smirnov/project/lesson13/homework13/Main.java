package com.smirnov.project.lesson13.homework13;

public class Main {
    public static void main(String[] args) {
        Action action03 = new Play(null);
        Action action02 = new Drink(action03);
        Action action01 = new Eat(action02);

        Animal animal = new Animal();
        animal.doAction(action01); // eat drink play
    }
}

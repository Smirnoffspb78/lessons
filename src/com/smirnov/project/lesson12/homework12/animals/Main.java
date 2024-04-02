package com.smirnov.project.lesson12.homework12.animals;

public class Main {
    public static void main(String[] args) {
        //Свойства объекта Wolf:
        //color - цвет - String
        //likeToEat - любимая еда - массив String (нужна проверка всех элементов массива)
        //strength - сила, т.к. наследуемся от WildAnimal
        //name - имя - String, т.к. наследуется от Animal
        //age - возраст - int, т.к. наследуется от Animal

        String[] eat= {"Косуля", "Кабан", "Лось"};
        String[] eat1= {"Гусь", "Курица", "Утка"};
        String[] eat2= {"Косуля", "Кабан", "Лось"};


        Wolf wolf=new Wolf(eat, "Серый");
        Wolf wolf1=new Wolf(eat1, "Черный");
        Wolf wolf2=new Wolf(eat2, "Серый");


        wolf.setAge(5);
        wolf1.setAge(7);
        wolf2.setAge(5);

        wolf.setName("Петя");
        wolf1.setName("Вася");
        wolf2.setName("Петя");


        wolf.setStrength(50);
        wolf1.setStrength(10);
        wolf2.setStrength(50);

        System.out.println(wolf);
        System.out.println(wolf1);
        System.out.println(wolf2);


        wolf.getStrength();
        wolf.getName();
        wolf.getAge();



        System.out.println(wolf1.equals(wolf));
        System.out.println(wolf.equals(wolf2));

    }
}

package com.smirnov.project.lesson08.homework8.task1;


public class CreateGroupClimber {
    static int numberPersonInOneGroup = 3;
    static int numberPersonInTwoGroup = 2;
    static int numberPersonInThreeGroup = 2;

    public static void main(String[] args) {
        Mountain[] taskMountain = new Mountain[3];
        taskMountain[0] = new Mountain("Эверест", "Китай", 8848);
        taskMountain[1] = new Mountain("Белуха", "Россия", 4506);
        taskMountain[2] = new Mountain("Эльбрус", "Россия", 5642);

        Climber[] taskClimber = new Climber[7];
        taskClimber[0] = new Climber("ИвАноВ", "улица Пушкина");
        taskClimber[1] = new Climber("Петров", "Улица Победы");
        taskClimber[2] = new Climber("Сидоров", "Улица Ленина");
        taskClimber[3] = new Climber("Михайлов", "Улица Спасская");
        taskClimber[4] = new Climber("Попов", "Улица Гороховая");
        taskClimber[5] = new Climber("Кузнецов", "Улица Зеленая");
        taskClimber[6] = new Climber("Морозов", "Улица Зеленая");

        GroupOfClimber groupOne = new GroupOfClimber(3, taskMountain[0]);
        GroupOfClimber groupTwo = new GroupOfClimber(5, taskMountain[1]);
        GroupOfClimber groupThree = new GroupOfClimber(4, taskMountain[2]);
        int counterTaskClimber = 0;
        for (int i = 0; i < numberPersonInOneGroup; i++) {
            groupOne.addClimberInGroup(taskClimber[counterTaskClimber]);
            counterTaskClimber++;
        }
        for (int i = 0; i < numberPersonInTwoGroup; i++) {
            groupTwo.addClimberInGroup(taskClimber[counterTaskClimber]);
            counterTaskClimber++;
        }
        for (int i = 0; i < numberPersonInThreeGroup; i++) {
            groupThree.addClimberInGroup(taskClimber[counterTaskClimber]);
            counterTaskClimber++;
        }

        groupOne.printNameClimbers();
        groupTwo.printNameClimbers();
        groupThree.printNameClimbers();
        boolean checkSetOne = groupOne.getCheckSet();
        boolean checkSetTwo = groupTwo.getCheckSet();
        boolean checkSetThree = groupThree.getCheckSet();

        GroupOfClimber fourGroup = new GroupOfClimber(0, taskMountain[0]);

        fourGroup.addClimberInGroup(taskClimber[6]);
    }
}

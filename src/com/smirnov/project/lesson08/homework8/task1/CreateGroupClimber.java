package com.smirnov.project.lesson08.homework8.task1;


public class CreateGroupClimber {
    public static void main(String[] args) {
        int numberPersonInOneGroup = 3;
        int numberPersonInTwoGroup = 2;
        int numberPersonInThreeGroup = 2;

        Mountain everest = new Mountain("Эверест", "Китай", 8848);
        Mountain beluha = new Mountain("Белуха", "Россия", 4506);
        Mountain elbrus = new Mountain("Эльбрус", "Россия", 5642);

        Climber[] taskClimber = new Climber[7];
        taskClimber[0] = new Climber("Иванов", "улица Пушкина");
        taskClimber[1] = new Climber("Петров", "Улица Победы");
        taskClimber[2] = new Climber("Сидоров", "Улица Ленина");
        taskClimber[3] = new Climber("Михайлов", "Улица Спасская");
        taskClimber[4] = new Climber("Попов", "Улица Гороховая");
        taskClimber[5] = new Climber("Кузнецов", "Улица Зеленая");
        taskClimber[6] = new Climber("Морозов", "Улица Зеленая");

        GroupOfClimber groupOne = new GroupOfClimber(3, everest);
        GroupOfClimber groupTwo = new GroupOfClimber(5, beluha);
        GroupOfClimber groupThree = new GroupOfClimber(4, elbrus);
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

        boolean checkSetOne = groupOne.isRecruitOpened();
        boolean checkSetTwo = groupTwo.isRecruitOpened();
        boolean checkSetThree = groupThree.isRecruitOpened();

       /* GroupOfClimber fourGroup = new GroupOfClimber(0, everest);
*/
      /*  fourGroup.addClimberInGroup(taskClimber[6]);*/
    }
}

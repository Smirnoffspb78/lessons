package com.smirnov.project.lesson10.homework10;

public class Main {
    public static void main(String[] args) {
        /**
         * Создание тестовых юнитов с помощью фабрики
         */
        Knight knight = (Knight) Units.generateUnit(TypeBattleUnit.KNIGHT);
        Knight knight1 = (Knight) Units.generateUnit(TypeBattleUnit.KNIGHT);
        System.out.println(knight.equals(knight1));






        System.out.println("Проверка атаки рыцаря на рыцаря "+knight1.attack(knight));

        System.out.println("Рыцарь "+knight);
        System.out.println("Рыцарь1 "+knight1);
        /**
         * Создание тестового юнита с помощью конструктора
         */
        Infantryman infantryman = new Infantryman(100, 7, 500, 10);
        Infantryman infantryman1 = new Infantryman(100, 3, 500, 10);

        System.out.println("Быстрый пехотинец "+infantryman);
        System.out.println("Медленный пехотинец "+infantryman);
        /**
         * Проведение тестовой атаки юнитом
         */

        infantryman.attack(knight);

        System.out.println("Рыцарь после атаки быстрого пехотинца "+knight);
        System.out.println("Быстрый пехотинец после ответной атаки рыцаря "+infantryman);

        infantryman1.attack(knight);

        System.out.println("Рыцарь после атаки медленного пехотинца "+knight);
        System.out.println("Медленный пехотинец после атаки рыцаря "+infantryman1);

        System.out.println("нападение рыцаря на другого рыцаря "+knight.attack(knight1));

        System.out.println("Рыцарь1 после атаки рыцаря "+knight);
        System.out.println("Рыцарь после ответной атаки рыцаря1 "+knight1);

        System.out.println("Возможность напасть на самого себя "+knight.attack(knight));
       /**
         * Cооздание королей и наем армий
         */
        King king3 = new King(500, 20);
        King king4 = new King(100, 20);
        System.out.println(king3);
        System.out.println(king4);

        System.out.println("Возможность обновить юнита без армии "+king3.updateUnitInArmy(TypeBattleUnit.KNIGHT));
        System.out.println("Возможность нападаения на самого себя "+king3.attackKings(king3));
        System.out.println("Возможность нападения без армии "+king3.attackKings(king4));
        System.out.println(king3.getCash());
        System.out.println(king4.getCash());
        king3.hiringArmy();
        System.out.println("Возможность нападения короля c армией на короля без армии "+king3.attackKings(king4));
        System.out.println(king3.getCash());
        System.out.println(king4.getCash());
        king4.hiringArmy();



        System.out.println("До боя: король3, король4");
        System.out.println(king3);
        System.out.println(king4);

        /**
         * Бой королей
         */


        System.out.println("После боя: 3, 4");
        king3.attackKings(king4);
        System.out.println(king3);
        System.out.println(king4);

        /**
         * Результаты распределения денег между королями
         */
        System.out.println("Количество денег 3,4");
        System.out.println(king3.getCash());
        System.out.println(king4.getCash());
        /**
         * Отдых и замена воинов
         */
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.KNIGHT));
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.INFANTRYMAN));
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.KNIGHT));
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.INFANTRYMAN));
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.INFANTRYMAN));
        System.out.println(king3.updateUnitInArmy(TypeBattleUnit.INFANTRYMAN));
        /**
         * После отдыха и замены
         */
        System.out.println("После замены");
        System.out.println(king3);
        System.out.println(king3.getCash());
        System.out.println("После отдыха 0-го рыцаря");
        System.out.println(king3.getBattleUnits()[0].getHealth());
        king3.getBattleUnits()[0].rest();
        System.out.println(king3.getBattleUnits()[0].getHealth());

        /**
         * Бой с новым королем
         */
        King king = new King(100, 10);
        king.hiringArmy();

        System.out.println("Перед боем 1, 4");
        System.out.println(king);
        System.out.println(king4);

        king4.attackKings(king);

        System.out.println("После боя 1,4 ");
        System.out.println(king);
        System.out.println(king4);

        /**Лечение рыцарем другого персонажа
         *
         */
       System.out.println("Количество денег рыцаря до лечения: "+knight.getCash());
       System.out.println("Количество денег рыцаря 0 из армии короля 1: "+king.getBattleUnits()[0].getCash());
       System.out.println("принудительное снижения здоровья");
        king.getBattleUnits()[0].setHealth(20);
        System.out.println(king.getBattleUnits()[0].getHealth());
       System.out.println("Лечение рыцарем рыцаря из армии 1: "+ knight.toHeal(king.getBattleUnits()[0], 20));
        System.out.println("Количество денег рыцаря после лечения: "+knight.getCash());
        System.out.println("Количество денег рыцаря из армии после лечения: "+king.getBattleUnits()[0].getCash());
        System.out.println("Количество здоровья рыцаря из армии после лечения: "+king.getBattleUnits()[0]);
        System.out.println("Начальное здоровье рыцаря из армии: "+ king.getBattleUnits()[0].getHealthInitial());
        System.out.println("проверка лецения здоровья на больше, чем было изначально"+ knight.toHeal(king.getBattleUnits()[0], 50));
        System.out.println("Количество денег рыцаря из армии после лечения: "+king.getBattleUnits()[0].getCash());
        System.out.println("Количество здоровья рыцаря из армии после лечения: "+king.getBattleUnits()[0]);


        System.out.println("Количество здоровья рыцаря изначально: "+knight.getHealthInitial());
        System.out.println("проверка возможности лечить самого себя: "+ knight.toHeal(knight, 2));

/*

        Knight knight5 = (Knight) Units.generateUnit(null);
        System.out.println("5ый юнит"+knight5);
*/


    }
}

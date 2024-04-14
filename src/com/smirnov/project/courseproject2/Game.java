package com.smirnov.project.courseproject2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static com.smirnov.project.courseproject2.Menu.EXIT;
import static java.lang.System.in;
import static java.lang.System.out;

public class Game {
    /**
     * Класс, обслуживающий игру
     */
    private class MenuInvoker2 implements Command {
        /**
         * Выполнить действие.
         *
         * @param numberMenu
         */
        @Override
        public void execute(int numberMenu) {
            String firstParagraph;

                switch (numberMenu){
                case 1 -> executeFile( fileQuest.getMapText().keySet().stream()
                        .findFirst()
                        .orElse(""));
                case 2-> executeFile( "Лисенок");/*"Нужно подумать";*/ //Скорее всего буферный файл. А буферный файл будет создаваться при выйти в меню. Дефолтно там убдет "Лисенок"
                case 3 -> {//Удалить буферный файл
                }
                case 4 -> EXIT.getName() /*"Получение записи из буферного файла и запись в файл"*/;
                case 5 -> EXIT.getName()/*"Получение записи из постоянного файла и передача в executeFile"*/;
                default -> throw new IllegalStateException("Unexpected value: " + numberMenu);
            }
        }
    }


    public Game() throws FileNotFoundException {
    }



    /**
     * Основной класс
     */
    private FileQuest fileQuest = new FileQuest();
    private Scanner scanner = new Scanner(in);
    private MenuInvoker2 menuInvoker2=new MenuInvoker2();

    public void start() {
        int userInput;
        out.println("Выберете пункт меню.");
        Arrays.stream(Menu.values()).forEach(menu -> out.printf("%d. %s%n", menu.getNumberMenu(), menu.getName()));
        menuInvoker2.execute(scanner.nextInt()); //Потом внести в вниз
        //Обращение к Мапе по ключу (номер пункта меню)

        //Вызов executeFile и передача возвращаемого занчения
    }

    private void executeFile(String string) {
        out.println(fileQuest.getMapText().get(string).getFirst());
        if (fileQuest.getMapText().get(string).size() != 1) {
            String nextKey = fileQuest.getMapText().get(string).get(scanner.nextInt());
            for (String key : fileQuest.getMapText().keySet()) {
                if (nextKey.contains(key)) {
                    executeFile(key);
                    break;
                }
            }
        }
        start();
    }

}

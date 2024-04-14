package com.smirnov.project.courseproject2;

public class MenuInvoker implements Command {
    /**
     * Выполнить действие.
     *
     * @param numberMenu
     */
    @Override
    public void execute(int numberMenu) {
        /*return switch (numberMenu){
            case 1 -> "Лисенок";
            case 2-> "Нужно подумать"; //Скорее всего буферный файл. А буферный файл будет создаваться при выйти в меню. Дефолтно там убдет "Лисенок"
            case 3 -> EXIT.getName(); //Может вообще ничего не нужно возвращать и этого case не нужно
            case 4 -> "Получение записи из буферного файла и запись в файл";
            case 5 -> "Получение записи из постоянного файла и передача в executeFile";
            default -> throw new IllegalStateException("Unexpected value: " + numberMenu);
        };*/
    }
}

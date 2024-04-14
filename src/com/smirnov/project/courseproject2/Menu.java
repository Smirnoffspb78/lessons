package com.smirnov.project.courseproject2;

/**
     * Меню игры.
     */
    enum Menu {
        START("Начать игру.", 1) {
           
            public void execute(Command command) {


            }
        },
        RETURN_IN_GAME("Вернуться к игре.", 2) {

            public void execute(Command command) {

            }
        },
        EXIT("Выход.", 3) {

            public void execute(Command command) {

            }
        },
        SAVE("Сохранить.", 4) {

            public void execute(Command command) {

            }
        },
        DOWNLOAD("Загрузить.", 5) {

            public void execute(Command command) {

            }
        };
        /*private FileQuest fileQuest;*/
        private final String name;
        private final int numberMenu;

        Menu(String name, int numberMenu) {
            this.name = name;
            this.numberMenu = numberMenu;
        }

        public String getName() {
            return name;
        }

    public int getNumberMenu() {
        return numberMenu;
    }
}
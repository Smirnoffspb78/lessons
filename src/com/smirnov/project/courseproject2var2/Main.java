package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(Arrays.toString(args));

        String qest1 = "Лисенок";
        List<String> qest1List = new ArrayList<>(Arrays.asList("Вернуться домой",
                "Отправиться на поиски")
        );
        String quest1Text = "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на\n" +
                "их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \"\n" +
                "Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?";

        String qest2 = "Вернуться домой";
        String quest2Text = "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой\n" +
                "злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! <b>Игра\n" +
                "завершилась успехом</b>";
        //Пустой лист

        String qest3 = "Отправиться на поиски";
        List<String> qest3List = new ArrayList<>(Arrays.asList("Попытаться разузнать о Бельчонке у лесных жителей",
                "Искать Бельчонка в одиночку"));
        String quest3Text = "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел\n" +
                "Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.";


        String qest4 = "Попытаться разузнать о Бельчонке у лесных жителей";
        List<String> qest4List = new ArrayList<>(Arrays.asList(
                "Расспросить Сову",
                "Расспросить Волка"
        ));
        String quest4Text = "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы\n" +
                "с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?";

        String qest5 = "Искать Бельчонка в одиночку";
        String quest5Text = "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n" +
                "<b>Игра завершилась неудачей</b>";
        //Пустой лист


        String qest6 = "Расспросить Сову";
        List<String> qest6List = new ArrayList<>(Arrays.asList(
                "Поверить Сове и отправиться вглубь леса",
                "Искать Бельчонка в одиночку"
        ));
        String quest6Text = "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные\n" +
                "жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.";

        String qest7 = "Расспросить Волка";
        List<String> qest7List = new ArrayList<>(Arrays.asList(
                "Вернуться домой",
                "Искать Бельчонка в одиночку"
        ));
        String quest7Text = "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу\n" +
                "одному. И как теперь поступить?";

        Menu menu = new Menu();
        Game game = new Game(args[0]);
        Quest quest = new Quest(menu, game);
        quest.addAnswersAndQuestions(qest1, qest1List, quest1Text);
        quest.addAnswersAndQuestions(qest2, new ArrayList<>(), quest2Text);
        quest.addAnswersAndQuestions(qest3, qest3List, quest3Text);
        quest.addAnswersAndQuestions(qest4, qest4List, quest4Text);
        quest.addAnswersAndQuestions(qest5, new ArrayList<>(), quest5Text);
        quest.addAnswersAndQuestions(qest6, qest6List, quest6Text);
        quest.addAnswersAndQuestions(qest7, qest7List, quest7Text);

        menu.addCommand(new StartGameCommand("Начать игру", quest))
                .addCommand(new ContinueGameCommand("Продолжить игру", quest))
                .addCommand(new ExitGameCommand("Выйти из игры", quest))
                .addCommand(new SaveGameCommand("Сохранить игру", quest))
                .addCommand(new DownloadGameCommand("Загрузить игру", quest));
        quest.startMenu();


    }


}

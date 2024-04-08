package com.smirnov.project.courseproject2var2;

import com.smirnov.project.courseproject2var2.command.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String qest1 = "Лисенок";
        Map<Integer, String> qest1Map = new LinkedHashMap<>();
        qest1Map.put(1, "Вернуться домой");
        qest1Map.put(2, "Отправиться на поиски");
        String quest1Text = "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на\n" +
                "их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \"\n" +
                "Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?";

        String qest2 = "Вернуться домой";
        Map<Integer, String> qest2Map = new LinkedHashMap<>();
        String quest2Text = "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой\n" +
                "злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! <b>Игра\n" +
                "завершилась успехом</b>";


        String qest3 = "Отправиться на поиски";
        Map<Integer, String> qest3Map = new LinkedHashMap<>();
        String quest3Text = "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел\n" +
                "Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.";
        qest3Map.put(1, "Попытаться разузнать о Бельчонке у лесных жителей");
        qest3Map.put(2, "Искать Бельчонка в одиночку");

        String qest4 = "Попытаться разузнать о Бельчонке у лесных жителей";
        Map<Integer, String> qest4Map = new LinkedHashMap<>();
        String quest4Text = "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы\n" +
                "с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?";
        qest4Map.put(1, "Расспросить Сову");
        qest4Map.put(2, "Расспросить Волка");

        String qest5 = "Искать Бельчонка в одиночку";
        Map<Integer, String> qest5Map = new LinkedHashMap<>();
        String quest5Text = "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n" +
                "<b>Игра завершилась неудачей</b>";

        String qest6 = "Расспросить Сову";
        Map<Integer, String> qest6Map = new LinkedHashMap<>();
        String quest6Text = "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные\n" +
                "жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.";
        qest6Map.put(1, "Поверить Сове и отправиться вглубь леса");
        qest6Map.put(2, "Искать Бельчонка в одиночку");

        String qest7 = "Расспросить Волка";
        Map<Integer, String> qest7Map = new LinkedHashMap<>();
        String quest7Text = "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу\n" +
                "одному. И как теперь поступить?";
        qest7Map.put(1, "Вернуться домой");
        qest7Map.put(2, "Искать Бельчонка в одиночку");

        Game game = new Game();
        Menu menu = new Menu(game);
        menu.addCommand(new StartGameCommand("Начать игру"))
                .addCommand(new ContinueGame("Продолжить игру"))
                .addCommand(new ExitGameCommand("Выйти из игры"))
                .addCommand(new SaveGameCommand("Сохранить игру"))
                .addCommand(new DownloadGame("Загрузить игру"));

        QuestFile questFile = new QuestFile(menu);
        questFile.addAnswersAndQuestions(qest1, qest1Map, quest1Text);
        questFile.addAnswersAndQuestions(qest2, qest2Map, quest2Text);
        questFile.addAnswersAndQuestions(qest3, qest3Map, quest3Text);
        questFile.addAnswersAndQuestions(qest4, qest4Map, quest4Text);
        questFile.addAnswersAndQuestions(qest5, qest5Map, quest5Text);
        questFile.addAnswersAndQuestions(qest6, qest6Map, quest6Text);
        questFile.addAnswersAndQuestions(qest7, qest7Map, quest7Text);


        questFile.startQuest();
        System.out.println(questFile);
    }


}

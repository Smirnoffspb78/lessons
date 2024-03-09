package com.smirnov.project.courseproject1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Logger;


/**
 * Фитнес.
 */
public enum Fitness {
    GYM("Спортивный зал"),
    SWIMMING_POOL("Бассейн"),
    GROUP_CLASSES("Групповые занятия");
    /**
     * Количество одновременно зарегистрированных абонементов в секции фитнесе.
     */
    private static final int NUMBER_OF_REGISTRATION = 20;

    /**
     * Зарегистрированные в секции фитнеса.
     */
    private final SeasonTicket[] seasonTickets = new SeasonTicket[NUMBER_OF_REGISTRATION];

    /**
     * Дефолтный пользователь.
     */
    private final OwnerSeasonTicket defaultOwner;

    /**
     * Дефолтный абонемент.
     */
    private final SeasonTicket defaultSeasonTicket;
    /**
     * Наименование секции фитнеса.
     */
    private final String name;

    private static final Logger logger = Logger.getLogger(Fitness.class.getName());

    /**
     * Указатель на текущее место записи в массиве.
     */
    private int counterSeasonTicket;

    /**
     * Конструктор создает секцию фитнеса.
     *
     * @param name Наименование секции фитнеса
     */
    Fitness(String name) {
        this.name = name;
        defaultOwner = new OwnerSeasonTicket("DefaultName", "DefaultSurname", LocalDate.now().getYear() - 1);
        defaultSeasonTicket = new SeasonTicket(defaultOwner);
    }

    /**
     * Заполняет секцию фитнеса дефолтными пользователями.
     */
    public void addDefaultTicket() {
        Arrays.fill(seasonTickets, defaultSeasonTicket);
        counterSeasonTicket = 0;
    }

    /**
     * Вспомогательный метод проверяет присутствие абонемента в одной из секций.
     *
     * @param seasonTicket Добавляемый абонемент
     * @return true/false если абонемент не зарегистрирован/уже зарегистрирован в секции
     */
    private static boolean checkRegistration(SeasonTicket seasonTicket) {
        Fitness[] fitnesses = Fitness.values();
        for (Fitness fitness : fitnesses) {
            for (int i = 0; i < fitness.counterSeasonTicket; i++) {
                if (fitness.seasonTickets[i] == seasonTicket) {
                    logger.info("Этот абонемент уже зарегистрирован в %s".formatted(fitness.getName()));
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Добавляет абонемент в секцию фитнеса.
     *
     * @param typeFitness  Секция фитнеса
     * @param seasonTicket Абонемент
     * @return true/false в случае успешного/неуспешного добавления пользователя в секцию фитнеса
     */
    public static boolean addTicket(Fitness typeFitness, SeasonTicket seasonTicket) {
        if (seasonTicket == null || typeFitness == null) {
            return false;
        }
        boolean checkedZone = false;
        for (int i = 0; i < seasonTicket.getTypeSeasonTicket().getTypeFitness().length; i++) {
            if (seasonTicket.getTypeSeasonTicket().getTypeFitness()[i] == typeFitness) {
                checkedZone = true;
            }
        }
        if (!checkedZone || seasonTicket.getTypeSeasonTicket().getBeginTime() > LocalTime.now().getHour()
                || seasonTicket.getTypeSeasonTicket().getEndTime() <= LocalTime.now().getHour()) {
            logger.info("Нет доступа в %s.".formatted(typeFitness.getName()));
            return false;
        } else if (!LocalDate.now().isBefore(seasonTicket.getDateEnding())) {
            logger.info("Абонемент просрочен.");
            return false;
        } else if (typeFitness.counterSeasonTicket >= NUMBER_OF_REGISTRATION) {
            logger.info("Все места заполнены.");
            return false;
        }
        if (!checkRegistration(seasonTicket)) {
            return false;
        }
        logger.info("%s добавлен в группу %s%nДата и время посещения: %s".formatted(seasonTicket.getOwnerSeasonTicket(), typeFitness.getName(), LocalDateTime.now()));
        typeFitness.seasonTickets[typeFitness.counterSeasonTicket++] = seasonTicket;
        return true;
    }

    /**
     * Выводит информацию о всех абонементах в секции.
     */
    public static void printAllSeasonTicket() {
        System.out.println("%s: %s%n%s: %s%n%s: %s".formatted(GYM.getName(), Arrays.toString(GYM.getSeasonTickets()),
                SWIMMING_POOL.getName(), Arrays.toString(SWIMMING_POOL.getSeasonTickets()), GROUP_CLASSES.getName(),
                Arrays.toString(GROUP_CLASSES.getSeasonTickets())));
    }

    public SeasonTicket[] getSeasonTickets() {
        SeasonTicket[] seasonTicketsCopy = new SeasonTicket[counterSeasonTicket];
        System.arraycopy(seasonTickets, 0, seasonTicketsCopy, 0, counterSeasonTicket);
        return seasonTicketsCopy;
    }

    public String getName() {
        return name;
    }
}

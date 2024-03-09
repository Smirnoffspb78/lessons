package com.smirnov.project.courseproject1var2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Logger;

import static com.smirnov.project.courseproject1var2.TypeFitness.*;
import static com.smirnov.project.courseproject1var2.TypeMembership.FULL_TIME;

public class Fitness {
    private static final Logger logger = Logger.getLogger(Fitness.class.getName());
    /**
     * Количество одновременно зарегистрированных абонементов в секции фитнесе.
     */
    private static final int NUMBER_OF_REGISTRATION = 20;
    /**
     * Тренажерный зал.
     */
    private final Membership[] membershipsGym = new Membership[NUMBER_OF_REGISTRATION];
    /**
     * Бассейн.
     */
    private final Membership[] membershipSwimmingPool = new Membership[NUMBER_OF_REGISTRATION];
    /**
     * Групповые занятия.
     */
    private final Membership[] membershipGroupClasses = new Membership[NUMBER_OF_REGISTRATION];

    /**
     * Указатель на текущее место записи в тренажерный зал.
     */
    private int counterGym;
    /**
     * Указатель на текущее место записи в бассейн.
     */
    private int counterSwimmingPool;
    /**
     * Указатель на текущее место записи в групповые занятия.
     */
    private int counterGroupClasses;

    /**
     * Дефолтный пользователь.
     */
    private final OwnerMembership defaultOwner = new OwnerMembership("DefaultName", "DefaultSurname", LocalDate.now().getYear() - 1);

    /**
     * Дефолтный абонемент.
     */
    private final Membership defaultMembership = new Membership(LocalDate.now().plusDays(1), defaultOwner, FULL_TIME);

    /**
     * Заполняет секцию фитнеса дефолтными пользователями.
     */
    public void addDefaultTicket(TypeFitness typeFitness) {
        switch (typeFitness) {
            case GYM -> {
                Arrays.fill(membershipsGym, defaultMembership);
                counterGym = 0;
            }
            case SWIMMING_POOL -> {
                Arrays.fill(membershipSwimmingPool, defaultMembership);
                counterSwimmingPool = 0;
            }
            case GROUP_CLASSES -> {
                Arrays.fill(membershipGroupClasses, defaultMembership);
                counterGroupClasses = 0;
            }
            default ->
                    throw new IllegalArgumentException("В метод addDefaultTicket передано недопустимое значение: %s".formatted(typeFitness));
        }
    }

    /**
     * Вспомогательный метод выбирает нужный указатель в зависимости от выбранной секции.
     *
     * @param typeFitness Тип секции
     * @return Указатель массива секции
     */
    private int getCounter(TypeFitness typeFitness) {
        switch (typeFitness) {
            case GYM -> {
                return counterGym;
            }
            case SWIMMING_POOL -> {
                return counterSwimmingPool;
            }
            case GROUP_CLASSES -> {
                return counterGroupClasses;
            }
            default ->
                    throw new IllegalArgumentException("В метод getCounter передано недопустимое значение: %s".formatted(typeFitness));
        }
    }

    /**
     * Вспомогательный метод проверяет наличие абонемента в секции.
     * @param memberships Секция
     * @param counter Указатель массива секции
     * @param membership Абонемент
     * @param typeFitness Тип секции
     * @return true/false если абонемент присутствует/не присутствует в секции
     */
    private boolean checkMembership(Membership[] memberships, int counter, Membership membership,
                                    TypeFitness typeFitness) {
        for (int i = 0; i < counter; i++) {
            if (memberships[i] == membership) {
                logger.info("Этот абонемент уже зарегистрирован в %s".formatted(typeFitness.getName()));
                return false;
            }
        }
        return true;
    }

    /**
     * Вспомогательный метод проверяет присутствие абонемента в одной из секций.
     *
     * @param membership Добавляемый абонемент
     * @return true/false если абонемент не зарегистрирован/уже зарегистрирован в секции
     */
    private boolean checkRegistration(Membership membership) {
        if (!checkMembership(membershipsGym, counterGym, membership, GYM)) {
            return false;
        } else if (!checkMembership(membershipSwimmingPool, counterSwimmingPool, membership, SWIMMING_POOL)) {
            return false;
        } else return checkMembership(membershipGroupClasses, counterGroupClasses, membership, GROUP_CLASSES);
    }

    /**
     * Добавляет абонемент в секцию фитнеса.
     *
     * @param typeFitness Секция фитнеса
     * @param membership  Абонемент
     * @return true/false в случае успешного/неуспешного добавления пользователя в секцию фитнеса
     */
    public boolean addTicket(TypeFitness typeFitness, Membership membership) {
        if (membership == null || typeFitness == null) {
            return false;
        }
        boolean checkedZone = false;
        for (int i = 0; i < membership.getTypeMembership().getTypeFitness().length; i++) {
            if (membership.getTypeMembership().getTypeFitness()[i] == typeFitness) {
                checkedZone = true;
            }
        }
        if (!checkedZone || membership.getTypeMembership().getBeginTime().isAfter(LocalTime.now())
                || !membership.getTypeMembership().getEndTime().isAfter(LocalTime.now())) {
            logger.info("Нет доступа в %s.".formatted(typeFitness.getName()));
            return false;
        } else if (!LocalDate.now().isBefore(membership.getDateEnding())) {
            logger.info("Абонемент просрочен.");
            return false;
        } else if (getCounter(typeFitness) >= NUMBER_OF_REGISTRATION) {
            logger.info("Все места заполнены.");
            return false;
        }
        if (!checkRegistration(membership)) {
            return false;
        }
        logger.info("%s добавлен в группу %s%nДата и время посещения: %s".formatted(membership.getOwnerMembership(), typeFitness.getName(), LocalDateTime.now()));
        switch (typeFitness) {
            case GYM -> membershipsGym[counterGym++] = membership;
            case SWIMMING_POOL -> membershipSwimmingPool[counterSwimmingPool++] = membership;
            case GROUP_CLASSES -> membershipGroupClasses[counterGroupClasses++] = membership;
            default ->
                    throw new IllegalArgumentException("В метод registration передано недопустимое значение: " + typeFitness);
        }
        return true;
    }

    /**
     * Выводит информацию о всех абонементах в секции.
     */
    public void printAllSeasonTicket() {
        System.out.printf("%s: %s%n%s: %s%n%s: %s%n", GYM.getName(), Arrays.toString(getMembershipsGym()),
                SWIMMING_POOL.getName(), Arrays.toString(getMembershipSwimmingPool()), GROUP_CLASSES.getName(),
                Arrays.toString(getMembershipGroupClasses()));
    }

    public Membership[] getMembershipsGym() {
        Membership[] seasonTicketsCopy = new Membership[counterGym];
        System.arraycopy(membershipsGym, 0, seasonTicketsCopy, 0, counterGym);
        return seasonTicketsCopy;
    }

    public Membership[] getMembershipSwimmingPool() {
        Membership[] seasonTicketsCopy = new Membership[counterSwimmingPool];
        System.arraycopy(membershipSwimmingPool, 0, seasonTicketsCopy, 0, counterSwimmingPool);
        return seasonTicketsCopy;
    }

    public Membership[] getMembershipGroupClasses() {
        Membership[] seasonTicketsCopy = new Membership[counterGroupClasses];
        System.arraycopy(membershipGroupClasses, 0, seasonTicketsCopy, 0, counterGroupClasses);
        return seasonTicketsCopy;
    }
}

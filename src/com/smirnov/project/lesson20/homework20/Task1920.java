package com.smirnov.project.lesson20.homework20;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.smirnov.project.lesson20.homework20.Article.Category.FOOD;
import static com.smirnov.project.lesson20.homework20.Article.Category.HISTORY;


public class Task1920 {
    public static void main(String[] args) {
        // Написать реализацию методов task01 - task04
        // Перед выполнением посмотрите методы flatMap / flatMapToInt / map / mapToInt / allMatch / anyMatch / noneMatch
        // Некоторые из этих методов могут понадобиться при решении задач

        Author author = new Author("Иван", "email0", LocalDate.now().minusYears(20));
        Author author2 = new Author("Иван", "email1", LocalDate.now().minusYears(34));
        Author author3 = new Author("Иван", "email2", LocalDate.now().minusYears(24));
        Author author4 = new Author("Иван", "email3", LocalDate.now().minusYears(29));
        Author author5 = new Author("Иван", "email4", LocalDate.now().minusYears(30));
        Author author6 = new Author("Иван", "email5", LocalDate.now().minusYears(30));

        Article article = new Article("Статья0", FOOD, author, author2, author3);
        Article article2 = new Article("Статья1", HISTORY, author, author2, author3, author4, author5, author5);
        Article article3 = new Article("Статья3", HISTORY, author6);
        Article article4 = new Article(null, HISTORY, author6);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(null);

        System.out.println(task01(articles));
        System.out.println(task02(articles, HISTORY));
        System.out.println(task03(articles, HISTORY, 19, 30));

        System.out.println((task04(articles, HISTORY)));


    }


    public static double task01(ArrayList<Article> articles) {
        // Вернуть средний возраст авторов статей
        Objects.requireNonNull(articles);
        return articles.stream().filter(Objects::nonNull).flatMap(article -> article.getAuthors().values().stream().distinct()).
                filter(author -> author != null && author.getBirth() != null && LocalDate.now().isAfter(author.getBirth())).
                mapToDouble(author -> LocalDate.now().getYear() - author.getBirth().getYear()).average().getAsDouble();
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список email авторов статей категории == category
        Objects.requireNonNull(articles);
        return articles.stream().filter(article -> article != null && article.getCategory() == category).
                flatMap(article -> article.getAuthors().values().stream()).distinct().
                filter(author -> author != null && author.getEmail() != null && !author.getEmail().isBlank()).
                map(Author::getEmail).collect(Collectors.toCollection(ArrayList::new));

    }

    public static List<Article> task03(ArrayList<Article> articles, Article.Category category, int min, int max) {
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max
        Objects.requireNonNull(articles);
        int year = LocalDate.now().getYear();
        return articles.stream().filter(article -> article != null && article.getCategory() == category).distinct().
                filter(article -> article.getAuthors().values().stream().filter(author -> author != null && author.getBirth() != null).
                        allMatch(author -> year - author.getBirth().getYear() <= max && year - author.getBirth().getYear() >= min)).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<Article> task04(ArrayList<Article> articles, Article.Category category) {
        Objects.requireNonNull(articles);
        if (articles.isEmpty()) {
            return new ArrayList<>();
        }
        // Вернуть список статей категории == category, опубликованных сегодня
        return articles.stream().filter(article -> article!=null && article.getCategory() == category).distinct().
                filter(article -> article.getPublished() != null && article.getPublished().toLocalDate().equals(LocalDate.now()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
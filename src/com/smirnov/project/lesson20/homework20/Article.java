package com.smirnov.project.lesson20.homework20;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public class Article {
    private HashMap<String, Author> authors;
    private String title;

    private Category category;
    private LocalDateTime published;

    public Article(String title, Category category, Author... authors) {
        this.authors = new HashMap<>();
        // Author... authors - массив авторов
        for (Author author : authors) {
            this.authors.put(author.getEmail(), author);
        }
        this.title = title;
        this.category = category;
        published = LocalDateTime.now().minusHours((long) (Math.random() * 24));
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public Category getCategory() {
        return category;
    }

    public HashMap<String, Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public enum Category {
        FOOD, TRAVELLING, SHOPPING, HISTORY
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(authors, article.authors) && Objects.equals(title, article.title) && category == article.category && Objects.equals(published, article.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authors, title, category, published);
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", category=" + category +
                '}';
    }
}

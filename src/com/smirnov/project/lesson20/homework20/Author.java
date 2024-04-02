package com.smirnov.project.lesson20.homework20;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private final String name;
    private final String email;
    private final LocalDate birth;

    public Author(String name, String email, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Author author)) {
            return false;
        }
        return Objects.equals(email, author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

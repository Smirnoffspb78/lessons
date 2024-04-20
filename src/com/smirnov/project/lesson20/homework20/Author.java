package com.smirnov.project.lesson20.homework20;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private final String name;
    private final String email;
    private final LocalDate birth;

    public Author(String name, String email, LocalDate birth) {
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        Objects.requireNonNull(birth);
        if (!LocalDate.now().isAfter(birth)) {
            throw new IllegalArgumentException();
        }
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

        if (!name.equals(author.name)) {
            return false;
        }
        if (!email.equals(author.email)) {
            return false;
        }
        return birth.equals(author.birth);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + birth.hashCode();
        return result;
    }
}

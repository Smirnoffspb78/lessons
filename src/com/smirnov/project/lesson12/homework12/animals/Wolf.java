package com.smirnov.project.lesson12.homework12.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal {
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Wolf{likeToEat=%s, color='%s' strength=%d' name=%s' age=%s}".formatted(Arrays.toString(likeToEat), color, getStrength(), getName(), getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf wolf)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(color, wolf.color) && Arrays.equals(likeToEat, wolf.likeToEat);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), color);
        result = 31 * result + Arrays.hashCode(likeToEat);
        return result;
    }
}

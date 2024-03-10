package com.smirnov.project.lesson12.homework12.animals;

import java.util.Objects;

public class WildAnimal extends Animal {
    private int strength;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WildAnimal that)) return false;
        if (!super.equals(o)) return false;
        return strength == that.strength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), strength);
    }
}

package com.smirnov.project.lesson22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sensor {
    private double temperature;

    private final List<Reactionable> reactionables = new ArrayList<>();

    public boolean addReactionable(Reactionable reactionable) {
        reactionables.add(Objects.requireNonNull(reactionable));
        return true;
    }

    public boolean removeReactionable(Reactionable reactionable) {
        reactionables.remove(Objects.requireNonNull(reactionable));
        return true;
    }

    public void temperatureRequest() {
        double temp = Math.random() * 1000;
        reactionables.forEach(reactionable -> reactionable.react(temp));
        setTemperature(temp);
    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

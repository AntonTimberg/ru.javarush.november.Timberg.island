package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Mouse extends Herbivore {
    double weight = (double) Math.round(((Math.random() * (MOUSE_WEIGHT - (MOUSE_WEIGHT * MINIMUM_WEIGHT_INDEX))) + (MOUSE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return MOUSE_WEIGHT;
    }

    public double getMaxPopulation() {
        return MOUSE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return MOUSE_MAX_SPEED;
    }

    public double getSaturation() {
        return MOUSE_SATURATION;
    }

    public String getUnicode() {
        return MOUSE_UNICODE;
    }

    @Override
    public String toString() {
        return "Mouse " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return MOUSE_EATING_MAP;
    }
}

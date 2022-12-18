package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Rabbit extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((RABBIT_WEIGHT - (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return RABBIT_WEIGHT;
    }

    public double getMaxPopulation() {
        return RABBIT_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return RABBIT_MAX_SPEED;
    }

    public double getSaturation() {
        return RABBIT_SATURATION;
    }

    public String getUnicode() {
        return RABBIT_UNICODE;
    }

    @Override
    public String toString() {
        return "Rabbit " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return RABBIT_EATING_MAP;
    }
}

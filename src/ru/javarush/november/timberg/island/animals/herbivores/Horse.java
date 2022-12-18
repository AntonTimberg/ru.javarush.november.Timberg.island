package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Horse extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((HORSE_WEIGHT - (HORSE_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (HORSE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return HORSE_WEIGHT;
    }

    public double getMaxPopulation() {
        return HORSE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return HORSE_MAX_SPEED;
    }

    public double getSaturation() {
        return HORSE_SATURATION;
    }

    public String getUnicode() {
        return HORSE_UNICODE;
    }

    @Override
    public String toString() {
        return "Horse " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return HORSE_EATING_MAP;
    }
}

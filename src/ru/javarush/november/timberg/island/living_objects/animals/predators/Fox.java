package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Fox extends Predator {
    {
        weight = (double) Math.round((Math.random()
                * ((FOX_WEIGHT - (FOX_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (FOX_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return FOX_WEIGHT;
    }

    public double getMaxPopulation() {
        return FOX_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return FOX_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return FOX_SATIETY;
    }

    public String getUnicode() {
        return FOX_UNICODE;
    }

    @Override
    public String toString() {
        return "Fox " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return FOX_EATING_MAP;
    }
}
package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Eagle extends Predator {
    {
        weight = (double) Math.round((Math.random()
                * ((EAGLE_WEIGHT - (EAGLE_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (EAGLE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return EAGLE_WEIGHT;
    }

    public double getMaxPopulation() {
        return EAGLE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return EAGLE_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return EAGLE_SATIETY;
    }

    public String getUnicode() {
        return EAGLE_UNICODE;
    }

    @Override
    public String toString() {
        return "Eagle " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return EAGLE_EATING_MAP;
    }
}

package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Deer extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((DEER_WEIGHT - (DEER_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (DEER_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return DEER_WEIGHT;
    }

    public double getMaxPopulation() {
        return DEER_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return DEER_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return DEER_SATIETY;
    }

    public String getUnicode() {
        return DEER_UNICODE;
    }

    @Override
    public String toString() {
        return "Deer " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return DEER_EATING_MAP;
    }
}

package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Rabbit extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((RABBIT_WEIGHT - (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return RABBIT_WEIGHT;
    }

    public double getMaxPopulation() {
        return RABBIT_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return RABBIT_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return RABBIT_SATIETY;
    }

    public String getUnicode() {
        return RABBIT_UNICODE;
    }

    @Override
    public String toString() {
        return "Rabbit " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return RABBIT_EATING_MAP;
    }
}

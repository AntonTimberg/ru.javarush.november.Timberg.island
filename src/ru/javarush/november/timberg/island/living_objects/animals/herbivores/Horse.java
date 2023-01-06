package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Horse extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((HORSE_WEIGHT - (HORSE_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (HORSE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return HORSE_WEIGHT;
    }

    public double getMaxPopulation() {
        return HORSE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return HORSE_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return HORSE_SATIETY;
    }

    public String getUnicode() {
        return HORSE_UNICODE;
    }

    @Override
    public String toString() {
        return "Horse " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return HORSE_EATING_MAP;
    }
}

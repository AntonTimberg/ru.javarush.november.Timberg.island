package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.BUFFALO_EATING_MAP;
import static ru.javarush.november.timberg.island.field.Config.BUFFALO_MAX_POPULATION;
import static ru.javarush.november.timberg.island.field.Config.BUFFALO_MAX_SPEED;
import static ru.javarush.november.timberg.island.field.Config.BUFFALO_SATIETY;
import static ru.javarush.november.timberg.island.field.Config.BUFFALO_UNICODE;
import static ru.javarush.november.timberg.island.field.Config.BUFFALO_WEIGHT;
import static ru.javarush.november.timberg.island.field.Config.MINIMUM_WEIGHT_INDEX;

public class Buffalo extends Herbivore {
    {
        weight = (double) Math.round((Math.random()
                * ((BUFFALO_WEIGHT - (BUFFALO_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1))
                + (BUFFALO_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    @Override
    public double getMaxWeight() {
        return BUFFALO_WEIGHT;
    }

    @Override
    public double getMaxPopulation() {
        return BUFFALO_MAX_POPULATION;
    }

    @Override
    public double getMaxSpeed() {
        return BUFFALO_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return BUFFALO_SATIETY;
    }

    @Override
    public String getUnicode() {
        return BUFFALO_UNICODE;
    }

    @Override
    public String toString() {
        return "Buffalo " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return BUFFALO_EATING_MAP;
    }
}

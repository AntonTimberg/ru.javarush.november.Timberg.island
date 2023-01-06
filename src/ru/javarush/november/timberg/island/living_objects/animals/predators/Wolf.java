package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;
import ru.javarush.november.timberg.island.field.Config;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.WOLF_EATING_MAP;

public class Wolf extends Predator {
    {
        weight = (double) Math.round((Math.random()
                * ((Config.WOLF_WEIGHT - (Config.WOLF_WEIGHT * Config.MINIMUM_WEIGHT_INDEX) + 1))
                + (Config.WOLF_WEIGHT * Config.MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return Config.WOLF_WEIGHT;
    }

    public double getMaxPopulation() {
        return Config.WOLF_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return Config.WOLF_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return Config.WOLF_SATIETY;
    }

    public String getUnicode() {
        return Config.WOLF_UNICODE;
    }

    @Override
    public String toString() {
        return "Wolf " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return WOLF_EATING_MAP;
    }
}

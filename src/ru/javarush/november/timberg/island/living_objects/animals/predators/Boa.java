package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.field.Config;
import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.BOA_EATING_MAP;

public class Boa extends Predator {
    {
        weight = (double) Math.round((Math.random()
                * ((Config.BOA_WEIGHT - (Config.BOA_WEIGHT * Config.MINIMUM_WEIGHT_INDEX) + 1))
                + (Config.BOA_WEIGHT * Config.MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return Config.BOA_WEIGHT;
    }

    public double getMaxPopulation() {
        return Config.BOA_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return Config.BOA_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return Config.BOA_SATIETY;
    }

    public String getUnicode() {
        return Config.BOA_UNICODE;
    }

    @Override
    public String toString() {
        return "Boa " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return BOA_EATING_MAP;
    }
}

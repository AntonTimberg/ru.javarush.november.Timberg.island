package ru.javarush.november.timberg.island.animals.predators;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Predator;
import ru.javarush.november.timberg.island.field.Config;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.BOA_EATING_MAP;

public class Boa extends Predator {
    double weight = (double) Math.round((Math.random() * ((Config.BOA_WEIGHT - (Config.BOA_WEIGHT * Config.MINIMUM_WEIGHT_INDEX) + 1)) + (Config.BOA_WEIGHT * Config.MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return Config.BOA_WEIGHT;
    }

    public double getMaxPopulation() {
        return Config.BOA_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return Config.BOA_MAX_SPEED;
    }

    public double getSaturation() {
        return Config.BOA_SATURATION;
    }

    public String getUnicode() {
        return Config.BOA_UNICODE;
    }

    @Override
    public String toString() {
        return "Boa " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return BOA_EATING_MAP;
    }
}

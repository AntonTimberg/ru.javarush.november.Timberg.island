package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;
import ru.javarush.november.timberg.island.field.Config;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.BEAR_EATING_MAP;

public class Bear extends Predator {
    double weight = (double) Math.round((Math.random() * ((Config.BEAR_WEIGHT - (Config.BEAR_WEIGHT * Config.MINIMUM_WEIGHT_INDEX) + 1)) + (Config.BEAR_WEIGHT * Config.MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return Config.BEAR_WEIGHT;
    }

    public double getMaxPopulation() {
        return Config.BEAR_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return Config.BEAR_MAX_SPEED;
    }

    public double getSatiety() {
        return Config.BEAR_SATIETY;
    }

    public String getUnicode() {
        return Config.BEAR_UNICODE;
    }

    @Override
    public String toString() {
        return "Bear " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    public void setCurrentWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return BEAR_EATING_MAP;
    }
}

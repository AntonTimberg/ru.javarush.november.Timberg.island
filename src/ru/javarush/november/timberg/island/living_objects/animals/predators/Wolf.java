package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;
import ru.javarush.november.timberg.island.field.Config;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.WOLF_EATING_MAP;

public class Wolf extends Predator {
    double weight = (double) Math.round((Math.random() * ((Config.WOLF_WEIGHT - (Config.WOLF_WEIGHT * Config.MINIMUM_WEIGHT_INDEX) + 1)) + (Config.WOLF_WEIGHT * Config.MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return Config.WOLF_WEIGHT;
    }

    public double getMaxPopulation() {
        return Config.WOLF_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return Config.WOLF_MAX_SPEED;
    }

    public double getSatiety() {
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
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public void setCurrentWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return WOLF_EATING_MAP;
    }
}

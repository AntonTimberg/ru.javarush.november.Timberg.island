package ru.javarush.november.timberg.island.animals.predators;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Predator;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Eagle extends Predator {
    double weight = (double) Math.round((Math.random() * ((EAGLE_WEIGHT - (EAGLE_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (EAGLE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return EAGLE_WEIGHT;
    }

    public double getMaxPopulation() {
        return EAGLE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return EAGLE_MAX_SPEED;
    }

    public double getSatiety() {
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
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public void setCurrentWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return EAGLE_EATING_MAP;
    }
}

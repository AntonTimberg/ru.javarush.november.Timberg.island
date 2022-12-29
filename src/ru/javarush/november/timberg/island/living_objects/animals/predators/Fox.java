package ru.javarush.november.timberg.island.living_objects.animals.predators;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Predator;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Fox extends Predator {
    double weight = (double) Math.round((Math.random() * ((FOX_WEIGHT - (FOX_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (FOX_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return FOX_WEIGHT;
    }

    public double getMaxPopulation() {
        return FOX_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return FOX_MAX_SPEED;
    }

    public double getSatiety() {
        return FOX_SATIETY;
    }

    public String getUnicode() {
        return FOX_UNICODE;
    }

    @Override
    public String toString() {
        return "Fox " + getUnicode();
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
        return FOX_EATING_MAP;
    }
}

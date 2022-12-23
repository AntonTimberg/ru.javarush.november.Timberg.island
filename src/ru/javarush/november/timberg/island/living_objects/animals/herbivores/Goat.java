package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Goat extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((GOAT_WEIGHT - (GOAT_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (GOAT_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return GOAT_WEIGHT;
    }

    public double getMaxPopulation() {
        return GOAT_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return GOAT_MAX_SPEED;
    }

    public double getSatiety() {
        return GOAT_SATIETY;
    }

    public String getUnicode() {
        return GOAT_UNICODE;
    }

    @Override
    public String toString() {
        return "Goat " + getUnicode();
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
        return GOAT_EATING_MAP;
    }
}

package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Rabbit extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((RABBIT_WEIGHT - (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (RABBIT_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return RABBIT_WEIGHT;
    }

    public double getMaxPopulation() {
        return RABBIT_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return RABBIT_MAX_SPEED;
    }

    public double getSatiety() {
        return RABBIT_SATIETY;
    }

    public String getUnicode() {
        return RABBIT_UNICODE;
    }

    @Override
    public String toString() {
        return "Rabbit " + getUnicode();
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
        return RABBIT_EATING_MAP;
    }
}

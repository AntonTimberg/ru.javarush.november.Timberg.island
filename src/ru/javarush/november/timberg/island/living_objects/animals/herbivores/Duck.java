package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.Animals;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Duck extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((DUCK_WEIGHT - (DUCK_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (DUCK_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return DUCK_WEIGHT;
    }

    public double getMaxPopulation() {
        return DUCK_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return DUCK_MAX_SPEED;
    }

    public double getSatiety() {
        return DUCK_SATIETY;
    }

    public String getUnicode() {
        return DUCK_UNICODE;
    }

    @Override
    public String toString() {
        return "Duck " + getUnicode();
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
        return DUCK_EATING_MAP;
    }
}

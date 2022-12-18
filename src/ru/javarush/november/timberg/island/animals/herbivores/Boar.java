package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;


public class Boar extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((BOAR_WEIGHT - (BOAR_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (BOAR_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    @Override
    public double getMaxWeight() {
        return BOAR_WEIGHT;
    }

    @Override
    public double getMaxPopulation() {
        return BOAR_MAX_POPULATION;
    }

    @Override
    public double getMaxSpeed() {
        return BOAR_MAX_SPEED;
    }

    @Override
    public double getSaturation() {
        return BOAR_SATURATION;
    }

    @Override
    public String getUnicode() {
        return BOAR_UNICODE;
    }

    @Override
    public String toString() {
        return "Boar " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return this.weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return BOAR_EATING_MAP;
    }
}

package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;


public class Sheep extends Herbivore {
    double weight = (double) Math.round((Math.random() * ((SHEEP_WEIGHT - (SHEEP_WEIGHT * MINIMUM_WEIGHT_INDEX) + 1)) + (SHEEP_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;

    public double getMaxWeight() {
        return SHEEP_WEIGHT;
    }

    public double getMaxPopulation() {
        return SHEEP_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return SHEEP_MAX_SPEED;
    }

    public double getSaturation() {
        return SHEEP_SATURATION;
    }

    public String getUnicode() {
        return SHEEP_UNICODE;
    }

    @Override
    public String toString() {
        return "Sheep " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return weight;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return SHEEP_EATING_MAP;
    }
}

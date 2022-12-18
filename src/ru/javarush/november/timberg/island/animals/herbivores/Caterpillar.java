package ru.javarush.november.timberg.island.animals.herbivores;

import ru.javarush.november.timberg.island.animals.Animals;
import ru.javarush.november.timberg.island.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Caterpillar extends Herbivore {

    public double getMaxWeight() {
        return CATERPILLAR_WEIGHT;
    }

    public double getMaxPopulation() {
        return CATERPILLAR_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return CATERPILLAR_MAX_SPEED;
    }

    public double getSaturation() {
        return CATERPILLAR_SATURATION;
    }

    public String getUnicode() {
        return CATERPILLAR_UNICODE;
    }

    @Override
    public String toString() {
        return "Caterpillar " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return CATERPILLAR_WEIGHT;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return CATERPILLAR_EATING_MAP;
    }
}

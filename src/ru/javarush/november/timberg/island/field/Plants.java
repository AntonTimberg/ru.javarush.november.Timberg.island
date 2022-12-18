package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animals;

import java.util.Map;

public class Plants implements CellObject{

    @Override
    public double getMaxWeight() {
        return Config.PLANTS_WEIGHT;
    }

    @Override
    public double getMaxPopulation() {
        return Config.PLANTS_MAX_POPULATION;
    }

    @Override
    public double getMaxSpeed() {
        return Config.PLANTS_MAX_SPEED;
    }

    @Override
    public double getSaturation() {
        return Config.PLANTS_SATURATION;
    }

    @Override
    public String getUnicode() {
        return Config.PLANTS_UNICODE;
    }

    @Override
    public String toString() {
        return "Plants " + getUnicode();
    }

    @Override
    public double getCurrentWeight() {
        return Config.PLANTS_WEIGHT;
    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return null;
    }
}

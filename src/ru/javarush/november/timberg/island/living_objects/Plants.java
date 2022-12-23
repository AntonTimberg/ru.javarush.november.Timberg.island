package ru.javarush.november.timberg.island.living_objects;

import ru.javarush.november.timberg.island.field.Config;
import ru.javarush.november.timberg.island.living_objects.animals.Animals;

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
    public double getSatiety() {
        return Config.PLANTS_SATIETY;
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
    public void setCurrentWeight(double weight) {

    }

    @Override
    public Map<Animals, Integer> getEatingProbability() {
        return null;
    }
}

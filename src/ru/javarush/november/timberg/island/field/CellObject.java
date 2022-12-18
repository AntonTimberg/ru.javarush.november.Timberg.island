package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animals;

import java.util.Map;

public interface CellObject {
    public double getMaxWeight();

    public double getMaxPopulation();

    public double getMaxSpeed();

    public double getSaturation();

    public String getUnicode();

    public double getCurrentWeight();

    public Map<Animals, Integer> getEatingProbability();
}

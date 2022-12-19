package ru.javarush.november.timberg.island.field;

import ru.javarush.november.timberg.island.animals.Animals;

import java.util.Map;

public interface CellObject {
    public double getMaxWeight();

    public double getMaxPopulation();

    public double getMaxSpeed();

    public double getSatiety();

    public String getUnicode();

    public double getCurrentWeight();

    public void setCurrentWeight(double weight);

    public Map<Animals, Integer> getEatingProbability();
}

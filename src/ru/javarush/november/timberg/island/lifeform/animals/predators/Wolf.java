package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.board.BoardSetting;
import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.WOLF_EATING_PROBABILITIES;
import static ru.javarush.november.timberg.island.board.BoardSetting.WOLF_MAX_POPULATION;

public class Wolf extends Animal {
    public double getMaxWeight() {
        return BoardSetting.WOLF_MAX_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return WOLF_MAX_POPULATION;
    }

    @Override
    public int getMaxSpeed() {
        return BoardSetting.WOLF_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return BoardSetting.WOLF_MAX_SATIETY;
    }

    @Override
    public double getCurrentSatiety() {
        return satiety;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return WOLF_EATING_PROBABILITIES;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WOLF;
    }

    public String getUnicode() {
        return BoardSetting.WOLF_UNICODE;
    }

    @Override
    public String toString() {
        return "Wolf " + getUnicode();
    }
}

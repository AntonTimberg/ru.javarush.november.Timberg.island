package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Bear extends Animal {
    @Override
    public double getMaxWeight() {
        return BEAR_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return BEAR_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return BEAR_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return BEAR_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return BEAR_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BEAR_MAX_SPEED;
    }
}

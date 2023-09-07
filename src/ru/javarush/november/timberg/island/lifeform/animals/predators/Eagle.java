package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Eagle extends Animal {
    @Override
    public double getMaxWeight() {
        return EAGLE_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return EAGLE_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return EAGLE_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return EAGLE_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return EAGLE_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return EAGLE_MAX_SPEED;
    }
}

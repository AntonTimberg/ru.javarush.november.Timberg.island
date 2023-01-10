package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Fox extends Animal {
    @Override
    public double getMaxWeight() {
        return FOX_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return FOX_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return FOX_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return FOX_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return FOX_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return FOX_MAX_SPEED;
    }
}

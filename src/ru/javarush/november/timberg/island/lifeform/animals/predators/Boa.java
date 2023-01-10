package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Boa extends Animal {
    @Override
    public double getMaxWeight() {
        return BOA_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return BOA_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return BOA_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BOA;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return BOA_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return BOA_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BOA_MAX_SPEED;
    }
}

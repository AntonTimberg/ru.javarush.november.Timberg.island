package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Deer extends Animal {
    @Override
    public double getMaxWeight() {
        return DEER_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return DEER_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DEER;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return DEER_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return DEER_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return DEER_MAX_SPEED;
    }

    @Override
    public int getMaxPopulation() {
        return DEER_MAX_POPULATION;
    }
}

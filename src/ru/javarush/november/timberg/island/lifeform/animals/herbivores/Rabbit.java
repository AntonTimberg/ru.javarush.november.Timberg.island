package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;


import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Rabbit extends Animal {

    public double getMaxWeight() {
        return RABBIT_MAX_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return RABBIT_MAX_POPULATION;
    }

    public int getMaxSpeed() {
        return RABBIT_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return RABBIT_SATIETY;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.RABBIT;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return RABBIT_EATING_PROBABILITIES;
    }

    public String getUnicode() {
        return RABBIT_UNICODE;
    }

    @Override
    public String toString() {
        return "Rabbit " + getUnicode();
    }
}

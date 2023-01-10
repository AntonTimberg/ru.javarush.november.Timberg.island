package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Sheep extends Animal {
    @Override
    public double getMaxWeight() {
        return SHEEP_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return SHEEP_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return SHEEP_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SHEEP;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return SHEEP_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return SHEEP_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return SHEEP_MAX_SPEED;
    }
}

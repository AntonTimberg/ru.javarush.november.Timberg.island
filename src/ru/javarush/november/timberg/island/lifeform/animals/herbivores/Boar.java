package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Boar extends Animal {
    @Override
    public double getMaxWeight() {
        return BOAR_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return BOAR_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BOAR;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return BOAR_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return BOAR_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BOAR_MAX_SPEED;
    }

    @Override
    public int getMaxPopulation() {
        return BOAR_MAX_POPULATION;
    }
}

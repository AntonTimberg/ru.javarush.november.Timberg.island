package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Duck extends Animal {
    @Override
    public double getMaxWeight() {
        return DUCK_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return DUCK_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DEER;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return DUCK_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return DUCK_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return DUCK_MAX_SPEED;
    }

    @Override
    public int getMaxPopulation() {
        return DUCK_MAX_POPULATION;
    }
}

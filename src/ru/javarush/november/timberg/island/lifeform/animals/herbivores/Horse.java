package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Horse extends Animal {
    @Override
    public double getMaxWeight() {
        return HORSE_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return HORSE_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return HORSE_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }

    @Override
    public Map<Class<? extends Organism>, Double> getProbabilityMap() {
        return HORSE_EATING_PROBABILITIES;
    }

    @Override
    public double getMaxSatiety() {
        return HORSE_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return HORSE_MAX_SPEED;
    }
}

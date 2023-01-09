package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Goat extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D
        );
    }

    @Override
    public double getMaxWeight() {
        return GOAT_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return GOAT_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return GOAT_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.GOAT;
    }

    @Override
    public double getMaxSatiety() {
        return GOAT_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return GOAT_MAX_SPEED;
    }
}

package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Sheep extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D
        );
    }

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
    public double getMaxSatiety() {
        return SHEEP_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return SHEEP_MAX_SPEED;
    }
}

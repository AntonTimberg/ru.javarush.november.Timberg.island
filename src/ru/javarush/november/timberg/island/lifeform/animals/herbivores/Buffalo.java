package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Buffalo extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D
                );
    }

    @Override
    public double getMaxWeight() {
        return BUFFALO_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return BUFFALO_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BUFFALO;
    }

    @Override
    public double getMaxSatiety() {
        return BUFFALO_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BUFFALO_MAX_SPEED;
    }
}

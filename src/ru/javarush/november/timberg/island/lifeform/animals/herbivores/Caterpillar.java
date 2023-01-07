package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Caterpillar extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D
        );
    }

    @Override
    public double getMaxWeight() {
        return CATERPILLAR_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return CATERPILLAR_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.CATERPILLAR;
    }

    @Override
    public double getMaxSatiety() {
        return CATERPILLAR_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return CATERPILLAR_MAX_SPEED;
    }
}

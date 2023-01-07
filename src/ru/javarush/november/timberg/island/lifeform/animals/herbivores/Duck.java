package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Duck extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D, Caterpillar.class, 0.9D
        );
    }

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
    public double getMaxSatiety() {
        return DUCK_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return DUCK_MAX_SPEED;
    }
}

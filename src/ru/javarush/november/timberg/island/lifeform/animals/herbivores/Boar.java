package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Boar extends Animal {

    {
        probabilities = Map.of(
                Caterpillar.class, 0.9D, Mouse.class, 0.5D, Plant.class, 1D
                );
    }

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
    public double getMaxSatiety() {
        return BOAR_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BOAR_MAX_SPEED;
    }
}

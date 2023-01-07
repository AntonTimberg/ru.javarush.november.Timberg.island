package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Caterpillar;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Duck;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Mouse;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Eagle extends Animal {

    {
        probabilities = Map.of(
                Fox.class, 0.1D, Mouse.class, 0.9D, Duck.class, 0.6D, Caterpillar.class, 0.4
        );
    }

    @Override
    public double getMaxWeight() {
        return EAGLE_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return EAGLE_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }

    @Override
    public double getMaxSatiety() {
        return EAGLE_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return EAGLE_MAX_SPEED;
    }
}

package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Mouse extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D, Caterpillar.class, 0.9D
        );
    }

    @Override
    public double getMaxWeight() {
        return MOUSE_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return MOUSE_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return MOUSE_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }

    @Override
    public double getMaxSatiety() {
        return MOUSE_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return MOUSE_MAX_SPEED;
    }
}

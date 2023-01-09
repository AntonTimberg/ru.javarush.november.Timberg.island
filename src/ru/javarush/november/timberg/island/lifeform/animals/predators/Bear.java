package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.*;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Bear extends Animal {

    {
        probabilities = Map.of(
                Boa.class, 0.8D, Horse.class, 0.4D, Deer.class, 0.8D, Rabbit.class, 0.8D, Mouse.class, 0.9D,
                Goat.class, 0.7D, Sheep.class, 0.7D, Boar.class, 0.5D, Buffalo.class, 0.2, Duck.class, 0.1
        );
    }

    @Override
    public double getMaxWeight() {
        return BEAR_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return BEAR_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return BEAR_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }

    @Override
    public double getMaxSatiety() {
        return BEAR_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BEAR_MAX_SPEED;
    }
}

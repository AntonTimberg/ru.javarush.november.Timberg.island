package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Duck;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Mouse;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Rabbit;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Eagle extends Animal {

    {
        probabilities = Map.of(
                Fox.class, 0.1D, Mouse.class, 0.9D,
                Duck.class, 0.8D, Rabbit.class, 0.9D
        );
    }

    @Override
    public double getMaxWeight() {
        return EAGLE_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return EAGLE_MAX_POPULATION;
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

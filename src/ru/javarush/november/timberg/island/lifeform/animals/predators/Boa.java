package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Duck;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Mouse;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Rabbit;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Boa extends Animal {

    {
        probabilities = Map.of(
                Rabbit.class, 0.2D, Fox.class, 0.15D, Mouse.class, 0.4D, Duck.class, 0.1D
        );
    }
    @Override
    public double getMaxWeight() {
        return BOA_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return BOA_MAX_POPULATION;
    }

    @Override
    public String getUnicode() {
        return BOA_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BOA;
    }

    @Override
    public double getMaxSatiety() {
        return BOA_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return BOA_MAX_SPEED;
    }
}

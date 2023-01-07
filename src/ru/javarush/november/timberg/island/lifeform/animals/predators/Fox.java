package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Caterpillar;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Duck;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Mouse;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.Rabbit;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Fox extends Animal {

    {
        probabilities = Map.of(
                Rabbit.class, 0.7D, Mouse.class, 0.9D, Duck.class, 0.6D, Caterpillar.class, 0.4D
        );
    }

    @Override
    public double getMaxWeight() {
        return FOX_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return FOX_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }

    @Override
    public double getMaxSatiety() {
        return FOX_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return FOX_MAX_SPEED;
    }
}

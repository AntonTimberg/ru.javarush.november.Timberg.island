package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Rabbit extends Animal {

    {
        probabilities = Map.of(Plant.class, 1D);
    }

    public double getMaxWeight() {
        return RABBIT_MAX_WEIGHT;
    }

    @Override
    public int getMaxPopulation() {
        return RABBIT_MAX_POPULATION;
    }

    public int getMaxSpeed() {
        return RABBIT_MAX_SPEED;
    }

    @Override
    public double getMaxSatiety() {
        return RABBIT_SATIETY;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.RABBIT;
    }

    public String getUnicode() {
        return RABBIT_UNICODE;
    }

    @Override
    public String toString() {
        return "Rabbit " + getUnicode();
    }
}

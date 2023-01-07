package ru.javarush.november.timberg.island.lifeform.animals.herbivores;

import ru.javarush.november.timberg.island.lifeform.Plant;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;

import java.util.Map;

import static ru.javarush.november.timberg.island.board.BoardSetting.*;

public class Horse extends Animal {

    {
        probabilities = Map.of(
                Plant.class, 1D
        );
    }

    @Override
    public double getMaxWeight() {
        return HORSE_WEIGHT;
    }

    @Override
    public String getUnicode() {
        return HORSE_UNICODE;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }

    @Override
    public double getMaxSatiety() {
        return HORSE_SATIETY;
    }

    @Override
    public int getMaxSpeed() {
        return HORSE_MAX_SPEED;
    }
}

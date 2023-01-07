package ru.javarush.november.timberg.island.lifeform.animals.predators;

import ru.javarush.november.timberg.island.board.BoardSetting;
import ru.javarush.november.timberg.island.board.Cell;
import ru.javarush.november.timberg.island.lifeform.Organism;
import ru.javarush.november.timberg.island.lifeform.animals.Animal;
import ru.javarush.november.timberg.island.lifeform.animals.AnimalType;
import ru.javarush.november.timberg.island.lifeform.animals.action.Action;
import ru.javarush.november.timberg.island.lifeform.animals.action.EatAction;
import ru.javarush.november.timberg.island.lifeform.animals.action.MoveAction;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanEat;
import ru.javarush.november.timberg.island.lifeform.animals.behavior.CanMove;
import ru.javarush.november.timberg.island.lifeform.animals.herbivores.*;

import java.util.List;
import java.util.Map;

public class Wolf extends Animal {

    {
        probabilities = Map.of(
                Rabbit.class, 0.8D, Horse.class, 0.1D, Deer.class, 0.15D, Mouse.class, 0.8D,
                Goat.class, 0.6D, Sheep.class, 0.7D, Boar.class, 0.15D, Buffalo.class, 0.1D,
                Duck.class, 0.4D
        );
    }

    public double getMaxWeight() {
        return BoardSetting.WOLF_MAX_WEIGHT;
    }

    @Override
    public int getMaxSpeed() {
        return BoardSetting.WOLF_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return BoardSetting.WOLF_MAX_SATIETY;
    }

    @Override
    public double getCurrentSatiety() {
        return satiety;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WOLF;
    }

    public String getUnicode() {
        return BoardSetting.WOLF_UNICODE;
    }

    @Override
    public String toString() {
        return "Wolf " + getUnicode();
    }
}

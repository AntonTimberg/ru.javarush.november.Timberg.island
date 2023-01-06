package ru.javarush.november.timberg.island.living_objects.animals.herbivores;

import ru.javarush.november.timberg.island.living_objects.animals.AnimalType;
import ru.javarush.november.timberg.island.living_objects.animals.Herbivore;

import java.util.Map;

import static ru.javarush.november.timberg.island.field.Config.*;

public class Mouse extends Herbivore {
    {
        weight = (double) Math.round(((Math.random()
                * (MOUSE_WEIGHT - (MOUSE_WEIGHT * MINIMUM_WEIGHT_INDEX)))
                + (MOUSE_WEIGHT * MINIMUM_WEIGHT_INDEX)) * 100) / 100;
        satiety = getMaxSatiety() * 0.5;
    }

    public double getMaxWeight() {
        return MOUSE_WEIGHT;
    }

    public double getMaxPopulation() {
        return MOUSE_MAX_POPULATION;
    }

    public double getMaxSpeed() {
        return MOUSE_MAX_SPEED;
    }

    public double getMaxSatiety() {
        return MOUSE_SATIETY;
    }

    public String getUnicode() {
        return MOUSE_UNICODE;
    }

    @Override
    public String toString() {
        return "Mouse " + getUnicode();
    }

    @Override
    public Map<AnimalType, Integer> getEatingProbability() {
        return MOUSE_EATING_MAP;
    }
}
